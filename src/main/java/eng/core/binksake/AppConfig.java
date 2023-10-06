package eng.core.binksake;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AppConfig implements WebMvcConfigurer {
    @Value("${app.file.img.path}")
    private String imagePath;

    @Value("${app.file.img.catalog}")
    private String imageCatalog;

    @Value("${app.file.audio.path}")
    private String audioPath;

    @Value("${app.file.audio.catalog}")
    private String audioCatalog;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(imagePath + "**")
                .addResourceLocations("file:" + imageCatalog);
        registry.addResourceHandler(audioPath + "**")
                .addResourceLocations("file:" + audioCatalog);
    }
}
