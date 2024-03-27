package com.example.board2.comm;

import org.junit.jupiter.api.Test;

class cm_encryptTest {

    @Test
    void encryptSha256() {
        /* 단방향 테스트 */
        Cm_encrypt cmEncrypt = new Cm_encrypt();

        String strName = "1234";
        System.out.println("단방향 : " + Cm_encrypt.encryptSha256(strName));
    }

    @Test
    void encryptAes() throws Exception {

        String strKey16= "ABCdefg123456plm";
        String strName = "홍길동 아버지는 누구인가";

        String strValue = Cm_encrypt.encryptAes(strName,strKey16);

        System.out.println("양방향 암호화 = " + strValue);


    }

    @Test
    void decryptAes() throws Exception {


        String strKey16= "ABCdefg123456plm";
        String strName = "SPKO6H7KLWeK7A8nyPZDbxUzxsKFauBgef4U+Ac8e2ynxl/4odo0KRYvAAiLEUqD";

        String strValue = Cm_encrypt.decryptAes(strName,strKey16);

        System.out.println("양방향 암호화 = " + strValue);
        System.out.println("strKey16.length() = " + strKey16.length());
    }
}