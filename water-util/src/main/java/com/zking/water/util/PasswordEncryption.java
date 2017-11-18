package com.zking.water.util;

import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

/**
 * PBKDF2(Password-Based Key Derivation Function)
 * 通过哈希算法进行加密。因为哈希算法是单向的，可以将任何大小的数据转化为定长的“指纹”，而且无法被反向计算。
 * 另外，即使数据源只改动了一丁点，哈希的结果也会完全不同。这样的特性使得它非常适合用于保存密码，
 * 因为我们需要加密后的密码无法被解密，同时也能保证正确校验每个用户的密码。但是哈希加密可以通过字典攻击和暴力攻击破解。
 * 密码加盐。盐是一个添加到用户的密码哈希过程中的一段随机序列。 这个机制能够防止通过预先计算结果的彩虹表破解。
 * 每个用户都有自己的盐，这样的结果就是即使用户的密码相同，通过加盐后哈希值也将不同。
 * 为了校验密码是否正确，我们需要储存盐值。通常和密码哈希值一起存放在账户数据库中，或者直接存为哈希字符串的一部分。
 * 
 * @author Administrator
 * 
 */

public class PasswordEncryption {

	public static final String PBKDF2_ALGORITHM = "PBKDF2WithHmacSHA1";

	/**
	 * 盐的长度
	 */
	public static final int SALT_BYTE_SIZE = 32 / 2;

	/**
	 * 生成密文的长度
	 */
	public static final int HASH_BIT_SIZE = 32 * 4;

	/**
	 * 迭代次数
	 */
	public static final int PBKDF2_ITERATIONS = 1000;

	/**
	 * 对输入的密码进行验证
	 * 
	 * @param attemptedPassword
	 *            待验证的密码
	 * @param encryptedPassword
	 *            密文
	 * @param salt
	 *            盐值
	 * @return 是否验证成功
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeySpecException
	 */
	public static boolean authenticate(String attemptedPassword,
			String encryptedPassword, String salt)
			throws NoSuchAlgorithmException, InvalidKeySpecException {
		// 用相同的盐值对用户输入的密码进行加密
		String encryptedAttemptedPassword = getEncryptedPassword(
				attemptedPassword, salt);
		// 把加密后的密文和原密文进行比较，相同则验证成功，否则失败
		return encryptedAttemptedPassword.equals(encryptedPassword);
	}

	/**
	 * 生成密文
	 * 
	 * @param password
	 *            明文密码
	 * @param salt
	 *            盐值
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeySpecException
	 */
	public static String getEncryptedPassword(String password, String salt)
			throws NoSuchAlgorithmException, InvalidKeySpecException {

		KeySpec spec = new PBEKeySpec(password.toCharArray(), fromHex(salt),
				PBKDF2_ITERATIONS, HASH_BIT_SIZE);
		SecretKeyFactory f = SecretKeyFactory.getInstance(PBKDF2_ALGORITHM);
		return toHex(f.generateSecret(spec).getEncoded());
	}

	/**
	 * 通过提供加密的强随机数生成器 生成盐
	 * 
	 * @return
	 * @throws NoSuchAlgorithmException
	 */
	public static String generateSalt() throws NoSuchAlgorithmException {
		SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
		byte[] salt = new byte[SALT_BYTE_SIZE];
		random.nextBytes(salt);

		return toHex(salt);
	}

	/**
	 * 十六进制字符串转二进制字符串
	 * 
	 * @param hex
	 *            the hex string
	 * @return the hex string decoded into a byte array
	 */
	private static byte[] fromHex(String hex) {
		byte[] binary = new byte[hex.length() / 2];
		for (int i = 0; i < binary.length; i++) {
			binary[i] = (byte) Integer.parseInt(
					hex.substring(2 * i, 2 * i + 2), 16);
		}
		return binary;
	}

	/**
	 * 二进制字符串转十六进制字符串
	 * 
	 * @param array
	 *            the byte array to convert
	 * @return a length*2 character string encoding the byte array
	 */
	private static String toHex(byte[] array) {
		BigInteger bi = new BigInteger(1, array);
		String hex = bi.toString(16);
		int paddingLength = (array.length * 2) - hex.length();
		if (paddingLength > 0)
			return String.format("%0" + paddingLength + "d", 0) + hex;
		else
			return hex;
	}

	/**
	 * 首先要生成一个盐值salt，再把原始密码和salt加密得到密文。
	 * 
	 * 验证的时候，把用户输入的密码和同样的盐值salt使用相同的加密算法得到一个密文，
	 * 
	 * 将这个密文和原密文相比较，相同则验证通过，反之则不通过。
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		String password = "zs123";
		String salt;
		String ciphertext;
		try {

			salt = PasswordEncryption.generateSalt();
			ciphertext = PasswordEncryption
					.getEncryptedPassword(password, salt);
			boolean result = PasswordEncryption.authenticate(password,
					ciphertext, salt);

			System.out.println(password + "  " + password.length());
			System.out.println(salt + "  " + salt.length());
			System.out.println(ciphertext + "  " + ciphertext.length());
			if (result) {
				System.out.println("succeed");
			} else {
				System.out.println("failed");
			}
		} catch (NoSuchAlgorithmException e) {
			System.out.println("NoSuchAlgorithmException");
		} catch (InvalidKeySpecException e) {
			System.out.println("InvalidKeySpecException");
		}
	}

	public static void main2(String[] args) {
		String password = "admin";
		String salt = "4672d9e68eff721ec82942ebc890e1a1";
		String ciphertext;
		try {

			// salt = PasswordEncryption.generateSalt();
			ciphertext = PasswordEncryption
					.getEncryptedPassword(password, salt);
			boolean result = PasswordEncryption.authenticate(password,
					ciphertext, salt);

			System.out.println(password + "  " + password.length());
			System.out.println(salt + "  " + salt.length());
			System.out.println(ciphertext + "  " + ciphertext.length());
			if (result) {
				System.out.println("succeed");
			} else {
				System.out.println("failed");
			}
		} catch (NoSuchAlgorithmException e) {
			System.out.println("NoSuchAlgorithmException");
		} catch (InvalidKeySpecException e) {
			System.out.println("InvalidKeySpecException");
		}
	}

	// admin 5
	// 4672d9e68eff721ec82942ebc890e1a1 32
	// 9c2248162e4e7560e836e6db28cdacc5 32
	// failed
}