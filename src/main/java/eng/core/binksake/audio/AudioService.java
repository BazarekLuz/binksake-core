package eng.core.binksake.audio;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AudioService {
    @Value("${app.file.audio.service-path}")
    private String AUDIO_PATH;
}
