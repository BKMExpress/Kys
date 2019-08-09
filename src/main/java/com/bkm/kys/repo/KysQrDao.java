package com.bkm.kys.repo;

import com.bkm.kys.core.qr.Person;
import com.bkm.kys.core.qr.Qr;
import com.bkm.kys.domain.KysQr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class KysQrDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void save(KysQr kysQr ) {
        String sql =
                "insert into KYSQR (QR_ID, QR_TYPE, QR_TEXT, MERCHANT_NAME, MERCHANT_CITY, AMOUNT, " +
                                   "TERMINAL_TYPE, INST_NUMBER, RRN, CREATED_DATE) " +
                "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";


        jdbcTemplate.update(sql, kysQr.getQrId(), kysQr.getQrType(), kysQr.getQrText(), kysQr.getMerchantName(), kysQr.getMerchantCity(),
                                 kysQr.getAmount(), kysQr.getTerminalType(), kysQr.getInstallmentNumber(), kysQr.getRnn(), kysQr.getCreatedDate());

    }

    public KysQr findByQrId(String qrId) {
        List<KysQr> kysQr = jdbcTemplate.query("select QR_ID, QR_TYPE, QR_TEXT, MERCHANT_NAME, MERCHANT_CITY, AMOUNT, TERMINAL_TYPE, " +
                                                          "INST_NUMBER, RRN, CREATED_DATE " +
                                                   "from KYSQR " +
                                                   "where QR_ID = " + qrId , (resultSet, i) -> { return toKysQr(resultSet); } );

        return kysQr != null ? kysQr.get(0) : null;
    }


    public List<KysQr> loadAll() {
        return jdbcTemplate.query("select * from KysQr", (resultSet, i) -> {
            return toKysQr(resultSet);
        });
    }

    private KysQr toKysQr(ResultSet resultSet) throws SQLException {
        KysQr kysQr = new KysQr();
        kysQr.setQrId(resultSet.getString("QR_ID"));
        kysQr.setQrType(resultSet.getString("QR_TYPE"));
        kysQr.setQrText(resultSet.getString("QR_TEXT"));
        kysQr.setMerchantName(resultSet.getString("MERCHANT_NAME"));
        kysQr.setMerchantCity(resultSet.getString("MERCHANT_CITY"));
        kysQr.setAmount(resultSet.getBigDecimal("AMOUNT"));
        kysQr.setInstallmentNumber(resultSet.getInt("INST_NUMBER"));
        kysQr.setTerminalType(resultSet.getString("TERMINAL_TYPE"));
        kysQr.setRnn(resultSet.getString("RRN"));
        kysQr.setCreatedDate(resultSet.getDate("CREATED_DATE"));

        return kysQr;
    }
}



