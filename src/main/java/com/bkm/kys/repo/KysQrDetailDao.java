package com.bkm.kys.repo;

import com.bkm.kys.domain.KysQrDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class KysQrDetailDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void save(KysQrDetail kysQrDetail ) {
        String sql =
                "insert into KYSQR_DETAIL (ID, QR_ID, ENCRYPTED_CARD_DATA, ISSUER_ID, WALLET_ID, ECI, LOCATION_DATA," +
                                          "STATUS, REQUESTED_DATE, FINISHED_DATE) " +
                        "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";


        jdbcTemplate.update(sql, kysQrDetail.getId(), kysQrDetail.getQrId(), kysQrDetail.getEncryptedCardData(),
                                 kysQrDetail.getIssuerId(), kysQrDetail.getWalletId(), kysQrDetail.getEci(),
                                 kysQrDetail.getLocationData(), kysQrDetail.getStatus(),
                                 kysQrDetail.getRequestedDate(), kysQrDetail.getFinishedDate() );
    }

    public List<KysQrDetail> loadAll() {
        return jdbcTemplate.query("select * from KYSQR_DETAIL", (resultSet, i) -> {
            return toKysQrDetail(resultSet);
        });
    }

    private KysQrDetail toKysQrDetail(ResultSet resultSet) throws SQLException {
        KysQrDetail kysQrDetail = new KysQrDetail();
        kysQrDetail.setId(resultSet.getString("ID"));
        kysQrDetail.setQrId(resultSet.getString("QR_ID"));
        kysQrDetail.setIssuerId(resultSet.getString("ISSUER_ID"));
        kysQrDetail.setWalletId(resultSet.getString("WALLET_ID"));
        kysQrDetail.setEci(resultSet.getString("ECI"));
        kysQrDetail.setLocationData(resultSet.getString("LOCATION_DATA"));
        kysQrDetail.setStatus(resultSet.getString("STATUS"));
        kysQrDetail.setRequestedDate(resultSet.getDate("REQUESTED_DATE"));
        kysQrDetail.setFinishedDate(resultSet.getDate("FINISHED_DATE"));

        return kysQrDetail;
    }
}
