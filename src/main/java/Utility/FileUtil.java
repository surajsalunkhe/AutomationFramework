package Utility;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

/**
 * File utility class
 */
public final class FileUtil {

	private static final Logger LOGGER = LoggerFactory.getLogger(FileUtil.class);
	
	/* Empty private constructor as its a utility method
	 * See: http://checkstyle.sourceforge.net/config_design.html#HideUtilityClassConstructor
	 */
	private FileUtil() {
	}
	
	/**
	 * Flush out the file.
	 */
	public static void flushFile(String filePath) {		
		RandomAccessFile file  = null; 
		try { 
			file = new RandomAccessFile (filePath, "rw");
		    file.setLength(0); 
		    file.close();
		} catch (IOException e) { 
			LOGGER.error("Common(): Error flushing the temporary file.", e); 
		} finally {			
			try {
				if (file != null) {
					file.close();
				}
			} catch (IOException ex) {
					LOGGER.error("Common(): Error in closing the stream for the temporary file.", ex); 
			}			
		}	
	}
	
    /**
     * Read the file and convert it to string.
     * @param filePath
     * @return
     * @throws IOException
     */
 	public static String readFileAsString(String fileName, String filePath) {
 		String completeFilePath = filePath + fileName;
 		
 		LOGGER.info("COMPLETE FILE PATH = " + completeFilePath);
 		
 		byte[] buffer = new byte[(int) new File(completeFilePath).length()];
 	    BufferedInputStream inputStream = null;
 	    try {
 	    	inputStream = new BufferedInputStream(new FileInputStream(completeFilePath));
 	    	if (inputStream.read(buffer) > 0) {
				return new String(buffer);
			}
 	    } catch (IOException ignored) {
 	    	LOGGER.error("File not found or invalid path.\n", ignored);
 	    	return null;
 	    } finally {
            if (inputStream != null) {
                try { 
                       inputStream.close(); 
                } catch (IOException e) {
                       LOGGER.error("Error in closing the connection file.");
                }
          }
     }
		return Constants.EMPTY;
 	}
 	
	/**
	 * Read file contents and return a string.
	 * @param filepath
	 * @throws IOException
	 */
	public static String readFileAsString(String filepath) throws IOException {
		LOGGER.info("Reading file as a string, " + filepath);
		return FileUtils.readFileToString(new File(filepath));
	}
	
	/**
	 * Delete files having certain prefix and suffix
	 * @param dir
	 * @param prefix
	 * @param suffix
	 */
	public static void deleteFiles(File dir, final String prefix, final String suffix) {
		
		  File[] toBeDeleted;
		 
		  //Create a File filter for a specific pattern 
		  FileFilter filter = new FileFilter() {
	      @Override
	      public boolean accept(File pathname) {
	        	if (suffix != null) {
	        		return pathname.getName().startsWith(prefix) && pathname.getName().endsWith(suffix);
	        	} else {
	        		return pathname.getName().startsWith(prefix);
	        	}
	        }
	     };
	     
	     try { 
	    	// returns pathnames for files and directory
			toBeDeleted = dir.listFiles(filter);
			// for each pathname in pathname array
			if (toBeDeleted != null) {
				for (File f : toBeDeleted) {
			    	 if (f.exists() && !f.isDirectory()) {
						   if (!f.delete()) {
						        LOGGER.info("Can't remove " + f.getAbsolutePath());
						   }
			    	 }
				}
		    }
	     } catch (Exception e) {
	        // if any error occurs
	    	LOGGER.error("Failed to delete file." + e);
	     }

	}
	
	/**
 	 *  Copy source file path to destination file path.
 	 *  @param srcFilePath
 	 *  @param destFilePath
 	 */
 	public static void copyFile(String srcFilePath, String destFilePath) {
		File src = new File(srcFilePath);
		File dest = new File(destFilePath);
		try {
		    FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			LOGGER.error("Failed to copy src file path " + srcFilePath + " to destination file path " + destFilePath + " exception: \n" + e);
		}
 	}
 	
 	/**
 	 * Read file
 	 * @param filePath
 	 * @return
 	 * @throws IOException
 	 */
 	public static String readFile(String filePath) {
		byte[] buffer = new byte[(int) new File(filePath).length()];
		BufferedInputStream inputStream = null;
		try {
			inputStream = new BufferedInputStream(new FileInputStream(filePath));

			if (inputStream.read(buffer) > 0) {
				String returnString = new String(buffer);
				returnString = returnString.replace("\\:", ":");
				returnString = returnString.replace("\\!", "!");
				returnString = returnString.replace("\\=", "=");
				returnString = returnString.replace("\\#", "#");

				return returnString;
			}
		} catch (IOException ie) {
			LOGGER.error("File Error" + ie);
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException ie) {
					LOGGER.error("IO Error" + ie);
				}
			}
		}
		return null;
	}

 	/**
 	 * Write to file
 	 * @param filePath
 	 * @param buffer
 	 * @throws Exception
 	 */
	public static void writeFile(String filePath, byte[] buffer) throws Exception {
		BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(filePath));
		output.write(buffer);
		output.close();
	}
	
	/**
	 * The given text is written in the temporary file against the given key.
	 * @param key
	 * @param text
	 * @throws Exception
	 **/
	public static void writeToFile(String filePath, String key, String text){
		PrintWriter printWriter = null;
		try {
			printWriter = new PrintWriter(new FileWriter(filePath, true));
			printWriter.println(key + "=" + text);
		} catch (IOException e) {
			LOGGER.error("FileUtil(): Error in writing the data to the temporary file. \n", e);
		} finally {
			if (printWriter != null) {
				printWriter.close();			
			}
		}
	}
}
