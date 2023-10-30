import java.io.*;

public class Cuenta {
    private String correo;
    private String contrasena;

    private String nombreU;
    private boolean existe=usuarioExiste();
    public Cuenta(String coreo, String contrasena, String nombreU) {
        this.correo = coreo;
        this.contrasena = contrasena;
        this.nombreU = nombreU;
    }
    public Cuenta(String coreo, String contrasena) {
        this.correo = coreo;
        this.contrasena = contrasena;
        this.nombreU = "n/r";
    }

    public boolean canCreateUser(){
        return !verificarExistenciaDeCorreo();
    }
    public void crearCuenta(){
        crearCarpetaCuenta();
        crearArchivoContrasena();
        escribirContrasna();
    }

    private void escribirContrasna() {
        try {
            File archivo = new File("./Cuentas/"+this.correo+"/contraseña.txt");
            FileWriter fW = new FileWriter(archivo,true);
            fW.write(this.contrasena);
            fW.close();
        }catch (Exception e){
            System.out.println("error al escribir la contraseña:"+e);
        }
    }

    private void crearArchivoContrasena() {
        File archivo = new File("./Cuentas/"+this.correo+"/contraseña.txt");
        try {
            archivo.createNewFile();
        }catch (Exception e){
            System.out.println("no se ha podido el archivo contrasena");
        }

    }

    private void crearCarpetaCuenta() {
        File carpeta = new File("./Cuentas/"+this.correo);
        try {
            carpeta.mkdir();
        }catch (Exception e){
            System.out.println("no se ha podido crear la carpeta correo");
        }

    }


    public boolean usuarioExiste(){
        boolean correo= verificarExistenciaDeCorreo();
        boolean contra=verificarContra(correo);
        return correo && contra;
    }

    private boolean verificarContra(boolean correoExiste) {
        String contraAuxiliar="";
        File carpeta = new File("./Cuentas/"+this.correo+"/contraseña.txt");
        if (correoExiste){
            try {
                FileReader fr = new FileReader (carpeta);
                BufferedReader br = new BufferedReader(fr);
                String linea;
                while((linea=br.readLine())!=null){
                    contraAuxiliar+=linea;
                }
            }catch (Exception e){
                System.out.println("ha habido un error en ingredientes:"+e);
            }
            return contraAuxiliar.equals(this.contrasena);
        }else {
            return false;
        }
    }

    private boolean verificarExistenciaDeCorreo() {
        File carpeta = new File("./Cuentas/"+this.correo);
        return carpeta.exists();

    }

    public String getCoreo() {
        return correo;
    }

    public void setCoreo(String coreo) {
        this.correo = coreo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getNombreUArchivo() {
        String nombreU="";
        File archivoNombre= new File("./Cuentas/"+this.correo+"/nombreU.txt");
        if (!archivoNombre.exists()){
            return "n/r";
        }else {
            try {
                FileReader fr = new FileReader (archivoNombre);
                BufferedReader br = new BufferedReader(fr);
                String linea;
                while((linea=br.readLine())!=null){
                    nombreU+=linea;
                }
            }catch (Exception e){
                System.out.println("ha habido un error al leer el nombre:"+e);
            }
        }
        return nombreU;
    }

    public void setNombreUArchivo(String nombreU) {
        try {
            File archivo = new File("./Cuentas/"+this.correo+"/nombreU.txt");
            FileWriter fW = new FileWriter(archivo,true);
            fW.write(nombreU);
            fW.close();
        }catch (Exception e){
            System.out.println("error al escribir el nombre de usuario:"+e);
        }
    }
}
