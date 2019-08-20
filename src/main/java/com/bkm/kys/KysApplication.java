package com.bkm.kys;

import com.bkm.kys.core.generator.EmvQrGenerator;
import com.bkm.kys.core.generator.KkfQrGenerator;
import com.bkm.kys.core.generator.QrGenerator;
import com.bkm.kys.core.parser.EmvQrParser;
import com.bkm.kys.core.parser.KkfQrParser;
import com.bkm.kys.core.parser.QrParser;
import com.bkm.kys.core.qr.MerchantAccount;
import com.bkm.kys.core.qr.Qr;
import com.bkm.kys.service.QrService;
import com.bkm.kys.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@EntityScan("com.bkm.kys")
public class KysApplication implements CommandLineRunner {

    @Autowired
    private QrService example;

	private static Qr createKkfQr() {
		QrGenerator kkfQrGenerator = new KkfQrGenerator();
		Map<String, Object> map = new HashMap<>();
		map.put("payloadIndicator", "99");
		map.put("memberNo", "0099");
		String qrId = Util.generateQrId();
		map.put("qrId", qrId);
		map.put("hash", Util.hash(qrId));
		map.put("crc", "ABCD");
		Qr generatedKkfQr = kkfQrGenerator.generate(map);
		return generatedKkfQr;
	}

	private static Qr createEmvQr() {
		QrGenerator emvQrGenerator = new EmvQrGenerator();
		Map<String, Object> map = new HashMap<>();
		map.put("payloadIndicator", "01");
		map.put("pointOfInitiation", "12");
		map.put("categoryCode", "1234");
		map.put("currencyCode", "949");
		map.put("amount", "000000000123");
		map.put("indicator", "55");
		map.put("countryCode", "58");
		map.put("merchantName", "BKM Online Shop");
		map.put("merchantCity", "İSTANBUL");
		map.put("crc", "3A50");

		MerchantAccount merchantAccount = getMerchantAccount();
		map.put("merchantAccount", merchantAccount);

		String qrId = Util.generateQrId();
		map.put("qrId", qrId);
		map.put("hash", Util.hash(qrId));

		Qr generatedEmvQr = emvQrGenerator.generate(map);

		return generatedEmvQr;
	}
	public static void testKkfQr(){
		Qr generatedKkfQr = createKkfQr();
		System.out.println(generatedKkfQr.getQrText());

		QrParser kkfQrParser = new KkfQrParser();
		Qr parsedKkfQr = kkfQrParser.parse(generatedKkfQr.getQrText());
		System.out.println(parsedKkfQr.getQrText());
	}

	public static MerchantAccount getMerchantAccount() {
		MerchantAccount merchantAccount = new MerchantAccount();
		merchantAccount.setSerialNo("01234567890123456789123"); // util.generate

		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyMMddHHmmss");
		merchantAccount.setDateTime(now.format(formatter));

		String qrId = Util.generateQrId();
		merchantAccount.setQrId(qrId); // util.generate
		merchantAccount.setQrGenerator("0099"); // acquirer
		merchantAccount.setRequestAmount("2");
		merchantAccount.setQrType("1");   // enum dan alınabilir
		merchantAccount.setTerminalType("4");
		merchantAccount.setHash(Util.hash(qrId));
		merchantAccount.setSchemas("TDVMAUJ000");
		merchantAccount.setBrand("N"); // enum var

		merchantAccount.setBitmap26();
		merchantAccount.setBitmap27();

		return merchantAccount;
	}

	public static void testEmvQr(){
		Qr generatedEmvQr = createEmvQr();
		System.out.println(generatedEmvQr.getQrText());

		QrParser emvQrParser = new EmvQrParser();
		Qr parsedEmvQr = emvQrParser.parse(generatedEmvQr.getQrText());
		System.out.println(parsedEmvQr.getQrText());

		String qrText = "000201010212262000040FAS0108ABCDEFGH5204520453039495405999.05802TR5910MYMERCHANT6006ANKARA63043A50";

	}

	public static void main(String[] args) {
		//testKkfQr();
		//testEmvQr();
		SpringApplication.run(KysApplication.class, args);
	}

	@Override
	public void run(String... args) {
		//Qr emvQr = createEmvQr();

	}

}
