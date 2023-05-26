package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * The BasicInformation class represents the basic information of a person for a CV.
 * It provides methods to save, retrieve, and delete the basic information.
 * The information is stored in a JSON file along with an optional image file.
 * 
 * @author Wenxuan Wu
 */
public class BasicInformation {

    private String name;
    private int age;
    private String school;
    private String major;
    private String admission_time;
    private String graduation_time;
    private String image_path;

    /**
     * Constructs a BasicInformation object with the provided details.
     * 
     * @param name            The name of the person.
     * @param age             The age of the person.
     * @param school          The school attended by the person.
     * @param major           The major of the person.
     * @param admission_time  The admission time to the school.
     * @param graduation_time The graduation time from the school.
     */
    public BasicInformation(String name, int age, String school, String major, String admission_time,
            String graduation_time) {
        this.name = name;
        this.age = age;
        this.school = school;
        this.major = major;
        this.admission_time = admission_time;
        this.graduation_time = graduation_time;
    }

    /**
     * Sets the image path for the BasicInformation object.
     * 
     * @param path The path of the image file.
     */
    public void setImagePath(String path) {
        this.image_path = path;
    }

    /**
     * Retrieves the basic information from the JSON file.
     * 
     * @return The basic information in JSON format.
     * @throws URISyntaxException If the JSON file path is invalid.
     */
    public static String getBasicInformation() throws URISyntaxException {
        try {
            java.net.URL classResource = BasicInformation.class.getProtectionDomain().getCodeSource().getLocation();
            Path classDirectory = Paths.get(classResource.toURI());
            Path resourcesPath = classDirectory.getParent().getParent();
            Path mainResourcesPath = resourcesPath.resolve("src").resolve("main").resolve("resources");

            String jsonPath = mainResourcesPath.toString() + "/basicInformation.json";
            Path filePath = Paths.get(jsonPath);
            if (!Files.exists(filePath)) {
                throw new FileNotFoundException("JSON file not found at path: " + jsonPath);
            }

            byte[] encoded = Files.readAllBytes(filePath);
            return new String(encoded, StandardCharsets.UTF_8);

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Retrieves the file path of the JSON file containing the basic information.
     * 
     * @return The file path of the JSON file.
     * @throws URISyntaxException If the file path is invalid.
     */
    public String path() throws URISyntaxException {
        java.net.URL classResource = BasicInformation.class.getProtectionDomain().getCodeSource().getLocation();
        Path classDirectory = Paths.get(classResource.toURI());
        Path resourcesPath = classDirectory.getParent().getParent();
        Path mainResourcesPath = resourcesPath.resolve("src").resolve("main").resolve("resources");

        String jsonPath = mainResourcesPath.toString() + "/basicInformation.json";

        return jsonPath;
    }

    /**
     * Saves the basic information and optional image file to the JSON and image files, respectively.
     * 
     * @param image The image file to be saved.
     * @return The relative path to the saved files.
     * @throws JSONException If there is an error in creating the JSON object.
     */
    public String saveBasicInformation(File image) throws JSONException {
        try {
            java.net.URL classResource = BasicInformation.class.getProtectionDomain().getCodeSource().getLocation();
            Path classDirectory = Paths.get(classResource.toURI());
            Path resourcesPath = classDirectory.getParent().getParent();
            Path mainResourcesPath = resourcesPath.resolve("src").resolve("main").resolve("resources");

            String imagePath = mainResourcesPath.toString() + "/image.png";
            this.setImagePath(imagePath);

            JSONObject jsonObject = new JSONObject();
            jsonObject.put("name", this.name);
            jsonObject.put("age", this.age);
            jsonObject.put("school", this.school);
            jsonObject.put("major", this.major);
            jsonObject.put("admission_time", this.admission_time);
            jsonObject.put("graduation_time", this.graduation_time);
            jsonObject.put("image_path", this.image_path);
            String json = jsonObject.toString();

            File resourcesDirectory = new File(mainResourcesPath.toString());
            if (!resourcesDirectory.exists()) {
                resourcesDirectory.mkdir();
            }

            File jsonFile = new File(resourcesDirectory, "basicInformation.json");
            if (jsonFile.exists()) {
                jsonFile.delete();
            }
            if (jsonFile.createNewFile()) {
                FileWriter writer = new FileWriter(jsonFile);
                writer.write(json);
                writer.close();
            }

            File imageFile = new File(resourcesDirectory, "image.png");
            if (imageFile.exists()) {
                imageFile.delete();
            }
            if (image != null && imageFile.createNewFile()) {
                Files.copy(image.toPath(), imageFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
            }

            return resourcesDirectory.getPath();
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Saves the basic information with a predefined image based on the selection.
     * 
     * @param selection The selection number for the predefined image.
     * @return The relative path to the saved image file.
     * @throws JSONException If there is an error in creating the JSON object.
     */
    public String newSaveBasicInformation(int selection) throws JSONException {
        try {
            java.net.URL classResource = BasicInformation.class.getProtectionDomain().getCodeSource().getLocation();
            Path classDirectory = Paths.get(classResource.toURI());
            Path resourcesPath = classDirectory.getParent().getParent();
            Path mainResourcesPath = resourcesPath.resolve("src").resolve("main").resolve("resources");

            if (selection == 1) {
                this.image_path = mainResourcesPath.toString() + "/head1.jpeg";
            }
            if (selection == 2) {
                this.image_path = mainResourcesPath.toString() + "/head2.jpeg";
            }
            if (selection == 3) {
                this.image_path = mainResourcesPath.toString() + "/head3.jpeg";
            }
            if (selection == 4) {
                this.image_path = mainResourcesPath.toString() + "/head4.jpeg";
            }

            JSONObject jsonObject = new JSONObject();
            jsonObject.put("name", this.name);
            jsonObject.put("age", this.age);
            jsonObject.put("school", this.school);
            jsonObject.put("major", this.major);
            jsonObject.put("admission_time", this.admission_time);
            jsonObject.put("graduation_time", this.graduation_time);
            jsonObject.put("image_path", this.image_path);
            String json = jsonObject.toString();

            File resourcesDirectory = new File(mainResourcesPath.toString());
            if (!resourcesDirectory.exists()) {
                resourcesDirectory.mkdir();
            }

            File jsonFile = new File(resourcesDirectory, "basicInformation.json");
            if (jsonFile.exists()) {
                jsonFile.delete();
            }
            if (jsonFile.createNewFile()) {
                FileWriter writer = new FileWriter(jsonFile);
                writer.write(json);
                writer.close();
            }

            return this.image_path;
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Deletes the basic information and image files.
     * 
     * @return {@code true} if the files are successfully deleted, {@code false} otherwise.
     */
    public boolean deleteBasicInformation() {
        try {
            java.net.URL classResource = BasicInformation.class.getProtectionDomain().getCodeSource().getLocation();
            Path classDirectory = Paths.get(classResource.toURI());
            Path resourcesPath = classDirectory.getParent().getParent();
            Path mainResourcesPath = resourcesPath.resolve("src").resolve("main").resolve("resources");

            File jsonFile = new File(mainResourcesPath.toString() + "/basicInformation.json");
            File imageFile = new File(mainResourcesPath.toString() + "/image.png");

            boolean jsonDeleted = false;
            boolean imageDeleted = false;

            if (jsonFile.exists()) {
                jsonDeleted = jsonFile.delete();
            }
            if (imageFile.exists()) {
                imageDeleted = imageFile.delete();
            }

            return jsonDeleted && imageDeleted;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
