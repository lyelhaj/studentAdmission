package com.CGS.admission.studentAdmission.testUtil;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.math.BigInteger;
import java.security.SecureRandom;

/**
 *
 * @author maria
 */
public class TestUtil {
    private static SecureRandom random;

    private static SecureRandom getRandomGenerator()
    {
        if (random == null) random = new SecureRandom();
        return random;
    }

    public static String generateRandomString()
    {
        return new BigInteger(32, getRandomGenerator()).toString(32);
    }

    public static Long generateRandomLong(Long bound)
    {
        return getRandomGenerator().nextLong()+1l;
    }

    public static Long generateRandomLong()
    {
        return generateRandomLong(100l);
    }

    public static int generateRandomNumber() {
        return generateRandomNumber(100);
    }

    public static int generateRandomNumber(int bound)
    {
        return getRandomGenerator().nextInt(bound) + 1; // Guarantee not 0
    }

}
