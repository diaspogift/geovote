package com.geovote.controllers.restcontrollers;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import com.geovote.domain.context.election.*;
import com.geovote.rest.representation.*;
import com.sun.management.VMOption;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import com.geovote.domain.context.administrative.PollingStation;
import com.geovote.domain.context.administrative.Voter;
import com.geovote.services.intf.ElectionService;
import com.geovote.domain.context.helper.VoteMessage;
import com.geovote.services.intf.CandidateService;
import com.geovote.services.intf.PollingStationService;
import com.geovote.services.intf.VoterService;




@RestController
@Transactional
public class ElectionController {


    //TO DOOOOOOOOOOOOOOOOOOOOOOOOO
	private final SseEmitter sseEmitter = new SseEmitter(Long.MAX_VALUE);
    //TO DOOOOOOOOOOOOOOOOOOOOOOOOO


    @Autowired
	private ElectionService electionService;
	@Autowired
	private CandidateService candidateService;
	@Autowired
	private VoterService voterService;
	@Autowired
	private PollingStationService pollingStationService;
	@PersistenceContext
	private EntityManager em;


	@RequestMapping(value = "/elections", method = RequestMethod.POST)
	public void createNewElection(@RequestBody Election newElection) {

		electionService.createNewElection(newElection);
	}

    @RequestMapping(value = "/elections", method = RequestMethod.GET)
    public ElectionCollectionRepresentation retrieveAllElection() {

        electionService.retrieveAllElections();

        return new ElectionCollectionRepresentation(electionService.retrieveAllElections());
    }

	@RequestMapping(value = "/election/{code}", method = RequestMethod.GET)
	public Election findElectionByCode(@PathVariable String code) {

		return electionService.findElectionByCode(code);
	}

	@RequestMapping(value = "/election/{code}/candidates", method = RequestMethod.GET)
	public CandidateCollectionRepresentstion findElectionsCandidates(@PathVariable String code) {

		List<Candidate> electionsCandidates = electionService.findElectionsCandidates(code);

		return new CandidateCollectionRepresentstion(electionsCandidates);
	}

	@RequestMapping(value = "/election/{code}/candidatures", method = RequestMethod.POST)
	public void registerCandidateForElection(@PathVariable String code,
			@RequestBody CandidatureRepresentation candidatureRepresention) {

		Election foundElection = electionService.findElectionByCode(code);

		Candidate foundCandidate = candidateService
				.findCadidateByCode(candidatureRepresention.getCandidateRegistrationId());

		Candidature candidature = new Candidature(foundCandidate, foundElection, new Date(),
				candidatureRepresention.getCandidateSignature());

		electionService.registerCandidateForElection(code, candidature);
		;

	}




	@RequestMapping(value = "/election/{code}/votes", method = RequestMethod.POST)
	public void registerVoteForElection(@PathVariable String code, @RequestBody VoteRepresentation voteRepresentation) {

        System.out.println(voteRepresentation.toString());

        //System.out.println(foundVoter.getPollingStationInfo().getPollingStationCode());
        System.out.println(voteRepresentation.getPollingStationCode());



		Election foundElection = electionService.findElectionByCode(voteRepresentation.getElectionCode());


		///TO DOOOOOOOOOOOOOO
		Voter foundVoter = em.createQuery("select voter from Voter as voter where voter.voterNumber=:id",Voter.class)
				.setParameter("id", voteRepresentation.getVoterId())
				.getSingleResult();

		//Voter foundVoter = voterService.findVoterByVoterId(voteRepresentation.getVoterId());

		Vote vote = new Vote(foundVoter, foundElection,new Date() , voteRepresentation.getSignature());








        if(foundVoter.getPollingStationInfo().getPollingStationCode().equals(voteRepresentation.getPollingStationCode())){


            foundVoter.getVotes().add(vote);
            foundElection.getVotes().add(vote);




            PollingStation votersPollingStation = pollingStationService
                    .findPollingStationByCode(vote.getVoter().getPollingStationInfo().getPollingStationCode());



            votersPollingStation.updateCurrentVotes();





            VoteMessage message = new VoteMessage(foundElection.getCode(), foundVoter.getDistrictInfo().getDistrictCode(),
                    foundVoter.getConstituencyInfo().getConstituencyCode(),
                    foundVoter.getSubCountyInfo().getSubCountyCode(), foundVoter.getParishInfo().getParishCode(),
                    foundVoter.getPollingStationInfo().getPollingStationCode(), votersPollingStation.getCurrentVotes());

            try {



                JSONObject jsonObject = new JSONObject();
                jsonObject.put("electionCode", message.getElectionCode());
                jsonObject.put("districtCode", message.getDistrictCode());
                jsonObject.put("constituencyCode", message.getConstituencyCode());
                jsonObject.put("subCountyCode", message.getSubCountyCode());
                jsonObject.put("parishCode",message.getParishCode());
                jsonObject.put("pollingStationCode",message.getPollingStationCode());
                jsonObject.put("currentVotes", message.getCurrentVotes());




                //sseEmitter.send(builder.comment("c").data(message).id("id").name("newVote").build());
                sseEmitter.send(SseEmitter.event().name(jsonObject.toString()).data(message));
                // sseEmitter.send(message, MediaType.APPLICATION_JSON_UTF8);
                // sseEmitter.send(message);}

            } catch (IOException e) {

            } catch (JSONException e) {
                e.printStackTrace();
            }


        }else
            return;



	}

	@RequestMapping(value = "/election/{code}/themes", method = RequestMethod.POST)
	public void registerThemeForElection(@PathVariable String code, @RequestBody Theme theme) {

		electionService.registerThemeForElection(code, theme);

	}

	@RequestMapping(value = "/election/{code}/themes", method = RequestMethod.GET)
	public ThemeCollectionRepresentation findElectionsThems(@PathVariable String code) {

		List<Theme> electionsThemes = electionService.findElectionsThemes(code);

		return new ThemeCollectionRepresentation(electionsThemes);

	}

	@RequestMapping(value = "/election/{code}/theme/{themeId}", method = RequestMethod.GET)
	public Theme findElectionsThemeByThemId(@PathVariable String code, @PathVariable  String themeId) {

		return electionService.findElectionsThemeByCode(code, themeId);

	}

	@RequestMapping(value = "/election/{code}/theme/{themeId}/questions", method = RequestMethod.GET)
	public ElectionThemesQuestionsRepresentation findElectionThemesQuestions(@PathVariable String code, @PathVariable String themeId) {

		return new ElectionThemesQuestionsRepresentation(electionService.findElectionThemesQuestions(code, themeId));

	}


	@RequestMapping(value = "/election/{code}/theme/{themeCode}/questions", method = RequestMethod.POST)
	public void registerElectionThemesQuestions(@PathVariable String code, @PathVariable String themeCode, @RequestBody ElectionThemeQuestionRepresentation electionThemeQuestionRepresentation) {

	    String questionCode = electionThemeQuestionRepresentation.getCode();
	    String questionTitle = electionThemeQuestionRepresentation.getTitle();

	    System.out.println(electionThemeQuestionRepresentation.toString());

		electionService.registerElectionThemesQuestions(code, themeCode, questionCode, questionTitle);

	}

	@RequestMapping(value = "/election/{code}/theme/{themeCode}/question/{questionCode}", method = RequestMethod.GET)
	public Question findElectionThemesQuestionByCode(@PathVariable String code, @PathVariable String themeCode, @PathVariable String questionCode) {

		return electionService.findElectionThemesQuestionByCode(code, themeCode, questionCode);

	}

    @RequestMapping(value = "/election/{code}/theme/{themeCode}/questionresponse/{questionCode}", method = RequestMethod.PUT)
    public void updateElectionThemesQuestionByCode(@PathVariable String code, @PathVariable String themeCode, @PathVariable String questionCode, @RequestBody QuestionResponseRepresentation questionResponseRepresentation) {

	    List<CandidateCofficientRepresentation> candidatesCofficients = questionResponseRepresentation.getCandidatesCofficients();

	    for(CandidateCofficientRepresentation next : candidatesCofficients){

	        System.out.println(next.toString());
        }

        electionService.updateElectionThemesQuestionByCode(code, themeCode, questionCode, candidatesCofficients);

    }


    @RequestMapping(value = "/election/{code}/questionresponse/candidatesweight", method = RequestMethod.PUT)
    public void updateElectionThemesQuestionResponseWeightForCandidates(@PathVariable String code, @RequestBody QuestionResponseRepresentation questionResponseRepresentation) {

        List<CandidateCofficientRepresentation> candidatesCofficients = questionResponseRepresentation.getCandidatesCofficients();

        for(CandidateCofficientRepresentation next : candidatesCofficients){

            System.out.println(next.toString());
        }

        electionService.updateElectionThemesQuestionResponseWeightForCandidates(code, candidatesCofficients);

    }


	@RequestMapping("/event")
	public SseEmitter alertMeOfNewVote(HttpServletRequest request) {

		return sseEmitter;

	}

}
