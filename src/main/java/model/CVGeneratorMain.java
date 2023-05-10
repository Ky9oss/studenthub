package model;

import java.net.URISyntaxException;

public class CVGeneratorMain {
    public static void main(String[] args) throws URISyntaxException {
        CVGenerator cvGenerator = new CVGenerator();

        String basic_information = "{\"major\":\"major_content\",\"school\":\"school_content\",\"image_path\":\"/home/kadrex/Study/codes/java/jiti_lab/studenthub/src/main/resources/image.png\",\"name\":\"name_content\",\"graduation_time\":\"graduation_time_content\",\"admission_time\":\"admission_time_content\",\"age\":0}";
        String skills = "[{\"title\": \"title_content\", \"content\": \"content_content\", \"proficiency\": \"Advanced(for example)\", \"project\": \"java(for example)\"},{\"title2\": \"hahahaha22\", \"content\": \"conten22\", \"proficiency\": \"Advanced\", \"project\": \"java22\"}]";
        String activities = "[{\"title\": \"title_content\", \"content\": \"content_detail\", \"time\": \"xxxx-xx-xx\", \"type\": \"type_detail\", \"location\": \"beijing\"},{\"title\": \"title_content\", \"content\": \"content_detail\", \"time\": \"xxxx-xx-xx\", \"type\": \"type_detail\", \"location\": \"beijing(for example)\"}]";
        String roles = "[{\"title\": \"title_content\", \"content\": \"content_content\", \"time\": \"xxxx-xx-xx\"},{\"title\": \"title_detail\", \"content\": \"content_content\", \"time\": \"xxxx-xx-xx\"}]";
        String achievements = "[{\"title\": \"title_content\", \"content\": \"content_content\", \"time\": \"xxxx-xx-xx\", \"team\": \"111(for example)\", \"responsibility\": \"beijing\"},{\"title\": \"title_content\", \"content\": \"content_content\", \"time\": \"xxxx-xx-xx\", \"team\": \"222(example\", \"responsibility\": \"beijing(example)\"}]";

        cvGenerator.generateCV(basic_information, skills, activities, roles, achievements);
    }
}
