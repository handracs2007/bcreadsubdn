import org.cesecore.util.CertTools;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

public class Main {

    public static void main ( String[] args ) {
        final String CERT = "github.pem";

        try ( FileInputStream fis = new FileInputStream ( CERT ) ) {
            X509Certificate cert = ( X509Certificate ) CertificateFactory.getInstance ( "X509" ).generateCertificate ( fis );
            System.out.println ( CertTools.getSubjectDN ( cert ) );
        }
        catch ( IOException | CertificateException ex ) {
            ex.printStackTrace ( );
        }
    }
}