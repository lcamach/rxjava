public class ArchivosServices {

    public ObjRpta subirArchivo(String strRutaArchivo) {
        System.out.println("En produccion " + Thread.currentThread().getId() + " " + Thread.currentThread().getName());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {

        }
        return new ObjRpta("Laura", "Ruben");
    }

}
