
package workspace;
import java.util.ArrayList;

/**
    05200000054 || AHMET BURAK DİNÇ 


    
 */

public class Student {
    private String adSoyad;
    private int ogrenciNumarasi;
    private String telefonNumaralari;

    public Student() {
    }
    
    public Student(int ogrenciNumarasi,String adSoyad, String telefonNumaralari){
        this.adSoyad = adSoyad;
        this.ogrenciNumarasi = ogrenciNumarasi;
        this.telefonNumaralari = telefonNumaralari;
    }
    public Student(Student s1){
        this.adSoyad = s1.adSoyad;
        this.ogrenciNumarasi = s1.ogrenciNumarasi;
        this.telefonNumaralari = s1.telefonNumaralari;
    }

    /**
     * @return the adSoyad
     */
    public String getAdSoyad() {
        return adSoyad;
    }

    /**
     * @param adSoyad the adSoyad to set
     */
    public void setAdSoyad(String adSoyad) {
        this.adSoyad = adSoyad;
    }

    /**
     * @return the ogrenciNumarasi
     */
    public int getOgrenciNumarasi() {
        return ogrenciNumarasi;
    }

    /**
     * @param ogrenciNumarasi the ogrenciNumarasi to set
     */
    public void setOgrenciNumarasi(int ogrenciNumarasi) {
        this.ogrenciNumarasi = ogrenciNumarasi;
    }

    /**
     * @return the telefonNumaralari
     */
    public String getTelefonNumaralari() {
        return telefonNumaralari;
    }

    /**
     * @param telefonNumaralari the telefonNumaralari to set
     */
    public void setTelefonNumaralari(String telefonNumaralari) {
        this.telefonNumaralari = telefonNumaralari;
    }
    
    public String toString() {
    return getOgrenciNumarasi() + " , " + getAdSoyad() + " , " + getTelefonNumaralari();
    }

}
