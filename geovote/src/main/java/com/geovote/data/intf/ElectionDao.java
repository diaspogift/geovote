package com.geovote.data.intf;

import java.util.List;

import com.geovote.domain.context.election.Candidate;
import com.geovote.domain.context.election.Election;
import com.geovote.domain.context.election.Question;
import com.geovote.domain.context.election.Theme;
import com.geovote.rest.representation.CandidateCofficientRepresentation;
import com.geovote.rest.representation.ElectionNameCodeRepresentation;
import com.geovote.rest.representation.QuestionReponseRepresentation;

public interface ElectionDao {

	public void create(Election newElection);

	public List<Candidate> getElectionsCandidates(String code);

	public Election getElectionByCode(String code);

	public List<Theme> findElectionsThemes(String code);

	public Theme findElectionsThemeByCode(String electionCode, String themCode);


    List<Question> findElectionThemesQuestions(String code, String themeId);

	Question findElectionThemesQuestionByCode(String code, String themeCode, String questionCode);

	void registerElectionThemesQuestions(String code, String themeCode, String questionCode, String questionTitle);

	void updateElectionThemesQuestionByCode(String code, String themeCode, String questionCode,  List<CandidateCofficientRepresentation> candidatesCofficients);

	List<ElectionNameCodeRepresentation>   getAllElections();

    void updateElectionThemesQuestionResponseWeightForCandidates(String code, List<CandidateCofficientRepresentation> candidatesCofficients);
}
