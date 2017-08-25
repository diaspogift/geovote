package com.geovote.services.intf;

import java.util.List;

import com.geovote.domain.context.election.*;
import com.geovote.rest.representation.CandidateCofficientRepresentation;
import com.geovote.rest.representation.ElectionNameCodeRepresentation;

public interface ElectionService {

	 void createNewElection(Election newElection);

	 List<Candidate> findElectionsCandidates(String code);

	 Election findElectionByCode(String code);

	 void registerCandidateForElection(String code, Candidature candidature);

	 void registerVoteForElection(String code, Vote Vote);

	 void registerThemeForElection(String code, Theme theme);

	 List<Theme> findElectionsThemes(String code);
	
	 Theme findElectionsThemeByCode(String electionCode, String themCode);

    List<Question> findElectionThemesQuestions(String code, String themeId);

	Question findElectionThemesQuestionByCode(String code, String themeCode, String questionCode);

	void registerElectionThemesQuestions(String code1, String s, String code, String themeCode);

	void updateElectionThemesQuestionByCode(String code, String themeCode, String questionCode, List<CandidateCofficientRepresentation>  candidatesCofficients);

	List<ElectionNameCodeRepresentation> retrieveAllElections();

	void updateElectionThemesQuestionResponseWeightForCandidates(String code, List<CandidateCofficientRepresentation> candidatesCofficients);
}
