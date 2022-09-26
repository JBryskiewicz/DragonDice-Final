package pl.dragondice.dragondicefinal.domain.user_character_structure;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class FeatWrapper {
    private List<CharacterFeats> feats;
}

