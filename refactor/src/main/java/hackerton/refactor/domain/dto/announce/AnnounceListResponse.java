package hackerton.refactor.domain.dto.announce;

import hackerton.refactor.domain.entity.announce.Announce;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class AnnounceListResponse {
    private List<Announce> announces = new ArrayList<>();
}
