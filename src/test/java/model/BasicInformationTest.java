package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BasicInformationTest {

    private BasicInformation basicInformationUnderTest;

    @BeforeEach
    void setUp() {
        basicInformationUnderTest = new BasicInformation("name", 0, "school", "major", "admission_time",
                "graduation_time");
    }

    @Test
    void testGetBasicInformation() {
        assertThat(basicInformationUnderTest.getBasicInformation()).isEqualTo("");
    }

    @Test
    void testSaveBasicInformation() {
        assertThat(basicInformationUnderTest.saveBasicInformation()).isFalse();
    }

    @Test
    void testDeleteBasicInformation() {
        assertThat(basicInformationUnderTest.deleteBasicInformation()).isFalse();
    }

    @Test
    void testGetAllInformationForCV() {
        assertThat(basicInformationUnderTest.getAllInformationForCV()).isEqualTo("");
    }

    @Test
    void testSaveImage() {
        assertThat(basicInformationUnderTest.saveImage()).isFalse();
    }

    @Test
    void testGetImagePath() {
        assertThat(basicInformationUnderTest.getImagePath()).isEqualTo("");
    }
}
