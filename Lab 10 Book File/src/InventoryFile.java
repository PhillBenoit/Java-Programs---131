import java.io.RandomAccessFile;
import java.io.IOException;
import java.io.EOFException;

public class InventoryFile {

    private RandomAccessFile FileObj = null ;
    private String fileName = null ;


    public InventoryFile(){}

    public InventoryFile(String fileNameParm, String accessMode){
        this.fileName = fileNameParm ;
        try {
            FileObj = new RandomAccessFile(fileName, accessMode);
            System.out.format("Descriptor of %s: %s\n", fileName, FileObj.getFD().toString());
        } catch (IOException e) {
            exceptionStop();
        }
    }


    //-------------------------------------------------------------------------------------------------
    public void writeBookData(InventoryBook bookRecord){  
        
        try {
            FileObj.writeChars(bookRecord.getISBN());
            FileObj.writeChars(bookRecord.getTitle());
            FileObj.writeDouble(bookRecord.getPrice());
            FileObj.writeInt(bookRecord.getYearPublished());
            FileObj.writeInt(bookRecord.getQuantityOnHand());
        } catch (IOException e) {
            exceptionStop();
        }
        
    }

    //-------------------------------------------------------------------------------------------------
    public void readBookData(InventoryBook bookRecord) throws IOException, EOFException, Exception { 
        StringBuffer sb = new StringBuffer();
        for (int i = 0 ; i < InventoryBook.MAX_ISBN_LENGTH; i++) {
            sb.append(FileObj.readChar());
        }
        bookRecord.setISBN(sb.toString());
        
        sb.setLength(0);
        for (int i = 0 ; i < InventoryBook.MAX_TITLE_LENGTH; i++)  {
            sb.append(FileObj.readChar());
        }
        bookRecord.setTitle(sb.toString()) ;
        
        bookRecord.setPrice(FileObj.readDouble());
        bookRecord.setYearPublished(FileObj.readInt());
        bookRecord.setQuantityOnHand(FileObj.readInt());
    }

    public void readBookData(int recordToRead, InventoryBook bookRecord)
            throws IOException, EOFException, Exception { 
        long recordLocation = bookRecord.bytes() * recordToRead;
        FileObj.seek(recordLocation);
        readBookData(bookRecord);
    }

    //------------------------------------------------------------------------------------------------------ 
    public void updateRecord(int numberOfRecordToUpdate, InventoryBook bookRecord)
            throws IOException, EOFException, Exception { 
        long recordLocation = bookRecord.bytes() * numberOfRecordToUpdate;
        System.out.println("Record to update: " + numberOfRecordToUpdate + 
                " bookRecord.bytes(): " + bookRecord.bytes() + 
                " recordLocation: " + recordLocation) ;
        System.out.println("Update info:\n" + bookRecord.toString());
        FileObj.seek(recordLocation);
        writeBookData(bookRecord);
    }

    //------------------------------------------------------------------------------------------------------ 
    public void closeFile(){
        try {
            System.out.println("Closing " + FileObj.getFD().toString() + "\n");
            FileObj.close();
        } catch (IOException e) {
            exceptionStop();
        }
        
    }

    public long length(){
        try {
            return FileObj.length();
        } catch (IOException e) {
            exceptionStop();
        }
        return 0;
    }
    
    void exceptionStop(){
        System.err.format("IOException while using %s.\n", fileName);
        System.exit(-1);
    }
}
