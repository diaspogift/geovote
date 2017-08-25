package com.geovote.services.impl;

import java.util.List;

import javax.transaction.Transactional;

import com.geovote.domain.context.election.*;
import com.geovote.rest.representation.CandidateCofficientRepresentation;
import com.geovote.rest.representation.ElectionNameCodeRepresentation;
import com.geovote.rest.representation.QuestionReponseRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geovote.domain.context.administrative.PollingStation;
import com.geovote.data.intf.CandidateDao;
import com.geovote.data.intf.ElectionDao;
import com.geovote.services.intf.ElectionService;
import com.geovote.data.intf.PollingStationDao;
import com.geovote.data.intf.ThemeDao;

@Service
@Transactional
public class ElectionServiceImpl implements ElectionService {

	@Autowired
	private ElectionDao electionDao;
	@Autowired
	private PollingStationDao pollingStationDao;
	@Autowired
	private CandidateDao candidateDao;
	@Autowired
	private ThemeDao themeDao;

	@Override
	public void createNewElection(Election newElection) {

		electionDao.create(newElection);
	}




	@Override
	public List<Candidate> findElectionsCandidates(String code) {
		return electionDao.getElectionsCandidates(code);
	}

	@Override
	public Election findElectionByCode(String code) {
		return electionDao.getElectionByCode(code);
	}

	@Override
	public void registerCandidateForElection(String code, Candidature candidature) {

		Election foundElection = electionDao.getElectionByCode(code);
		foundElection.addCandidate(candidature);

	}

	@Override
	public void registerVoteForElection(String code, Vote vote) {

		Election foundElection = electionDao.getElectionByCode(code);
		foundElection.addVote(vote);
		PollingStation votersPollingStation = pollingStationDao
				.getPollingStationByCode(vote.getVoter().getPollingStationInfo().getPollingStationCode());
		votersPollingStation.updateCurrentVotes();

	}

	@Override
	public void registerThemeForElection(String code, Theme theme) {

		Election foundElection = electionDao.getElectionByCode(code);
		foundElection.addTheme(theme);

	}

	@Override
	public List<Theme> findElectionsThemes(String code) {

		return electionDao.findElectionsThemes(code);
	}


	@Override
	public List<Question> findElectionThemesQuestions(String code, String themeId) {
		return electionDao.findElectionThemesQuestions(code, themeId);
	}

	@Override
	public Question findElectionThemesQuestionByCode(String code, String themeCode, String questionCode) {
		return electionDao.findElectionThemesQuestionByCode(code, themeCode, questionCode);
	}

	@Override
	public void registerElectionThemesQuestions(String code, String themeCode, String questionCode, String questionTitle) {
		electionDao.registerElectionThemesQuestions(code,themeCode,questionCode,questionTitle);
	}


	@Override
	public Theme findElectionsThemeByCode(String electionCode, String themCode) {
		return electionDao.findElectionsThemeByCode(electionCode, themCode);
	}

	@Override
	public void updateElectionThemesQuestionByCode(String code, String themeCode, String questionCode, List<CandidateCofficientRepresentation> candidatesCofficients) {
		electionDao.updateElectionThemesQuestionByCode(code, themeCode, questionCode, candidatesCofficients);
	}

	@Override
	public List<ElectionNameCodeRepresentation> retrieveAllElections() {
		return electionDao.getAllElections();
	}

	@Override
	public void updateElectionThemesQuestionResponseWeightForCandidates(String code, List<CandidateCofficientRepresentation> candidatesCofficients) {
		electionDao.updateElectionThemesQuestionResponseWeightForCandidates(code,candidatesCofficients);
	}


}
