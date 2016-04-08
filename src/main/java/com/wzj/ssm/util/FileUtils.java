package com.wzj.ssm.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Properties;

public class FileUtils {

	private static Properties prop = null;
	private static String fileServerRealPath = null;
	private static String fileServerName = null;
	private static String fileServerUrl = null;
	
	static {
		InputStream in = null;
		try {
			// 读取配置文件，获文件服务器的路径
			in = FileUtils.class.getClassLoader().getResourceAsStream("fileServer.properties");
			prop = new Properties();
			prop.load(in);
			in.close();
		} catch (Exception e) {
			throw new RuntimeException("加载图片服务器配置文件失败");
		}
		fileServerRealPath = prop.getProperty("fileServerRealPath");
		fileServerName = prop.getProperty("fileServerName");
		fileServerUrl = prop.getProperty("fileServerUrl");
	}

	public static void savePicsIntoImageServer(String originRootPath, List<String> picPaths) {
		for (String picPath : picPaths) {
			File originFile = new File(originRootPath, picPath);
			File destFile = new File(fileServerRealPath, picPath);
			// 将上传的图片从临时目录中写入到图片服务器的路径中
			copyFile(originFile, destFile);
			deleteFileByPath(originRootPath, picPath);
		}
	}

	private static void copyFile(File originFile, File destFile) {
		InputStream bis = null;
		OutputStream bos = null;
		byte[] buffer = new byte[1024];
		try {
			if (originFile.exists() && !destFile.exists()) {
				createDestFile(destFile);
				bis = new BufferedInputStream(new FileInputStream(originFile));
				bos = new BufferedOutputStream(new FileOutputStream(destFile));
				while ((bis.read(buffer, 0, buffer.length)) != -1) {
					bos.write(buffer);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bis != null)
					bis.close();
				if (bos != null)
					bos.close();
				buffer = null;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void createDestFile(File file) throws IOException {
		if (!file.getParentFile().exists()) {
			file.getParentFile().mkdirs();
		} else {
			file.createNewFile();
		}
	}

	public static void deleteFileServer(String picPath) {
		deleteFileByPath(fileServerRealPath, picPath);
	}

	private static void deleteFileByPath(String rootPath,String picPath) {
		File destFile = new File(rootPath, picPath);
		// 路径为文件且不为空则进行删除
		if (destFile.isFile() && destFile.exists()) {
			destFile.delete();
		}
	}
	
	/*public static void cleanTempDir(String tempDir) {
		try {
			delAllFile(tempDir); // 删除完里面所有内容
			String filePath = tempDir;
			filePath = filePath.toString();
			File myFilePath = new File(filePath);
			myFilePath.delete(); // 删除空文件夹
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static boolean delAllFile(String tempDir) {
		boolean flag = false;
		File file = new File(tempDir);
		if (!file.exists()) {
			return flag;
		}
		if (!file.isDirectory()) {
			return flag;
		}
		String[] tempList = file.list();
		File temp = null;
		for (int i = 0; i < tempList.length; i++) {
			if (tempDir.endsWith(File.separator)) {
				temp = new File(tempDir + tempList[i]);
			} else {
				temp = new File(tempDir + File.separator + tempList[i]);
			}
			if (temp.isFile()) {
				temp.delete();
			}
			if (temp.isDirectory()) {
				delAllFile(tempDir + "/" + tempList[i]);// 先删除文件夹里面的文件
				cleanTempDir(tempDir + "/" + tempList[i]);// 再删除空文件夹
				flag = true;
			}
		}
		return flag;
	}*/

	


	
	
	public static String getFileServerRealPath() {
		return fileServerRealPath;
	}
	
	public static String getFileServerName() {
		return fileServerName;
	}
	
	public static String getFileServerUrl() {
		return fileServerUrl;
	}
	
}
