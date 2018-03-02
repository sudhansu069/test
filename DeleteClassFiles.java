import java.io.File;

public class DeleteClassFiles{
	
     private static final String SRC_FOLDER = "D://Dev_Tools//JavaTest//test";

     public static void main(String[] args) {
     	
     	deleteClassFiles();
     }
 


	  public static void deleteClassFiles(){

          File folder = new File(SRC_FOLDER);

          File[] allFiles =  folder.listFiles();

          for (int i = 0; i < allFiles.length; i++) {

          	   if (allFiles[i].isFile() && allFiles[i].getName().endsWith(".class")) {

          	   	   String fileName = allFiles[i].getName();
                   
                    allFiles[i].delete();

                    System.out.println("Deleted File:"+fileName);
               }
          }

	  }
}