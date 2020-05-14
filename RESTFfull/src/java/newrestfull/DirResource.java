package newrestfull;

import java.io.File;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 */
@Path("dir")
public class DirResource implements IDirectory {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of DirResource
     */
    public DirResource() {
    }

    @Override
    @GET
    @Path("{directory}")
    @Produces("text/html")
    public String getContent(@PathParam("directory") String dirName) {
        return getFolderContent(dirName);

    }

    @Override
    @GET
    @Path("find/{directory}")
    @Produces(MediaType.TEXT_HTML)
    public String findFile(@PathParam("directory") String dirName,
            @QueryParam("file") String fileName) {
        return findFiles(dirName, fileName);
    }

    @Override
    @GET
    @Path("alt")
    @Produces("text/html")
    public String altGetContent(@QueryParam("directory") String dirName) {
        return getFolderContent(dirName);
    }

    @Override
    @GET
    @Path("alt/find")  // для работы с любым каталогом в директории
    @Produces(MediaType.TEXT_HTML)
    public String altFindFile(@QueryParam("directory") String dirName,
            @QueryParam("file") String fileName) {
        return findFiles(dirName, fileName);
    }

    private String getFolderContent(String dirName) {
        StringBuilder sb;
        sb = new StringBuilder("<h2>getContent() called, dirName = " + dirName + "</h2><ol><big> ");
        File folder = new File(dirName);
        if (folder.listFiles() == null) {
            return "Folder '" + dirName + "' does not exist !";
        }
        for (File f : folder.listFiles()) {
            sb.append("<li>" + f.getName() + " - " + (f.isDirectory() ? "folder" : "file") + "</li>");
        }
        sb.append("</big></ol>");
        return sb.toString();
    }

    private String findFiles(String dirName, String fragment) {
//        StringBuilder sb;
//        sb = new StringBuilder("<h2>dirName = " + dirName + "</h2><ol><big> ");
//        File folder = new File(dirName);
//        if (folder.listFiles() == null) {
//            return "Folder '" + dirName + "' does not exist !";
//        }
//        FileSelect fileSelect = new FileSelect(fragment);
//
//        for (File f : folder.listFiles(fileSelect)) {
//            sb.append("<li>" + f.getName() + " - " + (f.isDirectory() ? "folder" : "file") + "</li>");
//        }
//        sb.append("</big></ol>");
//        return sb.toString();

        StringBuilder sb = new StringBuilder();
        sb.append("<h1>Content of folder '" + dirName + "':</h1>");
// получение имени директории     
        File folder = new File(dirName);
//Возвращение массива абстрактных путей, 
//обозначающих файлы в каталоге, обозначенном этим абстрактным путем.
        File[] content = folder.listFiles(new FileSelect(fragment));
        if (content == null) {
            sb.append("<h2> Folder '" + dirName + "' does not exist</h2>");
        } else {
            sb.append("<big><ol>");
            for (File f : content) {
                sb.append("<li><a href=\"" + f.getAbsolutePath() + "\">" + f.getName()
                        + " - " + (f.isDirectory() ? "folder" : "file") + "</a></li>");
            }
        }
        return sb.toString();
    }
}
/*
private String matchedFiles(String dirName, String fileName) {
        StringBuilder sb = new StringBuilder();
        sb.append("<h1>Content of folder '" + dirName + "':</h1>");
        File folder = new File(dirName);
        File[] content = folder.listFiles(new FileFinder(fileName));
        if (content == null) {
            sb.append("<h2> Folder '" + dirName + "' does not exist</h2>");
        } else {
            sb.append("<big><ol>");
            for (File f : content) {
                sb.append("<li><a href=\"" + f.getAbsolutePath() + "\">" + f.getName()
                        + " - " + (f.isDirectory() ? "folder" : "file") + "</a></li>");
            }
        }
        return sb.toString();
    }   
*/
