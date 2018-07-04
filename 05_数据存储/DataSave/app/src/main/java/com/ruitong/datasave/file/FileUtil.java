package com.ruitong.datasave.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;
import java.net.URLEncoder;

import android.content.Context;

public class FileUtil {
	
	protected static final String TAG = "FileUtil";
	
	public static final String MY_DIR_NAME = "Im";

	/**
	 * 文件序列化对象列表
	 * 
	 * @param context
	 * @param objs
	 * @param fileName
	 * @param mode
	 */
	public static void writeObjsToFile(Context context, Object obj, String fileName, int mode) {

		if (context == null || obj == null || fileName == null)
			return;

		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try {
			fos = context.openFileOutput(URLEncoder.encode(fileName, "UTF-8"), mode);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(obj);
			oos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (oos != null) {
					oos.close();
				}
				if (fos != null) {
					fos.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * 从序列化文件中读取对象列表
	 * 
	 * @param context
	 * @param fileName
	 * @return
	 */
	public static Object readObjsFromFile(Context context, String fileName) {

		if (fileName == null)
			return null;

		Object obj = null;
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fileName = URLEncoder.encode(fileName, "UTF-8");
			if (context.getFileStreamPath(fileName).exists()) {
				fis = context.openFileInput(fileName);
				ois = new ObjectInputStream(fis);
				obj = ois.readObject();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (StreamCorruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (ois != null) {
					ois.close();
				}
				if (fis != null) {
					fis.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return obj;
	}

	/**
	 * 判断文件是否存在
	 * @return
	 */
	public static boolean fileIsExists(Context context,String fileName) {
		try {
			File f = new File(context.getFilesDir(), fileName);
			if (!f.exists()) {
				return false;
			}

		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		return true;
	}

	
//	/**
//	 * 获取缓存大小
//	 * @param context
//	 * @return
//	 */
//	public static long getCacheSize(Context context) {
//
//		long size = 0;
//		try {
//			size += FileSizeUtil.getFileSizes(context.getCacheDir());
//			size += FileSizeUtil.getFileSizes(context.getFilesDir());
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		return size;
//	}
//	
//	public static String SDPATH = Environment.getExternalStorageDirectory() + "/" + MY_DIR_NAME + "/";
//
//	public static void saveBitmap(Bitmap bm, String picName) {
//		try {
//			if (!isFileExist("")) {
//				File tempf = createSDDir("");
//			}
//			File f = new File(SDPATH, picName + ".JPEG"); 
//			if (f.exists()) {
//				f.delete();
//			}
//			FileOutputStream out = new FileOutputStream(f);
//			bm.compress(Bitmap.CompressFormat.JPEG, 90, out);
//			out.flush();
//			out.close();
//			LogUtil.i(TAG, R.string.success_photo_save);
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//
//	public static File createSDDir(String dirName) throws IOException {
//		File dir = new File(SDPATH + dirName);
//		if (Environment.getExternalStorageState().equals(
//				Environment.MEDIA_MOUNTED)) {
//
//			System.out.println("createSDDir:" + dir.getAbsolutePath());
//			System.out.println("createSDDir:" + dir.mkdir());
//		}
//		return dir;
//	}
//
//	public static boolean isFileExist(String fileName) {
//		File file = new File(SDPATH + fileName);
//		file.isFile();
//		return file.exists();
//	}
//	
//	public static void delFile(String fileName){
//		File file = new File(SDPATH + fileName);
//		if(file.isFile()){
//			file.delete();
//        }
//		file.exists();
//	}
//
//	public static void deleteDir() {
//		File dir = new File(SDPATH);
//		if (dir == null || !dir.exists() || !dir.isDirectory())
//			return;
//		
//		for (File file : dir.listFiles()) {
//			if (file.isFile())
//				file.delete(); // 删除所有文件
//			else if (file.isDirectory())
//				deleteDir(); // 递规的方式删除文件夹
//		}
//		dir.delete();// 删除目录本身
//	}

	public static boolean fileIsExists(String path) {
		try {
			File f = new File(path);
			if (!f.exists()) {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}
}
