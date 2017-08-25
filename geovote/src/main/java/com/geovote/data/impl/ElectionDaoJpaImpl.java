package com.geovote.data.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.geovote.domain.context.election.*;
import com.geovote.domain.context.result.QuestionReponse;
import com.geovote.data.intf.ElectionDao;
import com.geovote.rest.representation.CandidateCofficientRepresentation;
import com.geovote.rest.representation.ElectionNameCodeRepresentation;
import com.geovote.rest.representation.QuestionReponseRepresentation;
import org.springframework.stereotype.Repository;


@Repository
public class ElectionDaoJpaImpl implements ElectionDao {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void create(Election newElection) {
		em.persist(newElection);
	}



    @Override
	public List<Candidate> getElectionsCandidates(String code) {
		
		return em.createQuery("select candidate from Candidate as candidate where candidate.electionInfo.electionCode =:code",Candidate.class)
				.setParameter("code", code)
				.getResultList();
	}

	@Override
	public Election getElectionByCode(String code) {

		return em.createQuery("select election from Election as election  where election .code =:code",Election.class)
				.setParameter("code", code)
				.getSingleResult();
	}

	@Override
	public List<Theme> findElectionsThemes(String code) {
		
		return em.createQuery("select theme from Theme as theme where theme.code =:code",Theme.class)
				.setParameter("code", code)
				.getResultList();
	}

	@Override
	public Theme findElectionsThemeByCode(String electionCode, String themCode) {



		Object[] pairElectionTheme = em.createQuery("select election, theme from Election  election  join  election.themes  as theme where election.code =:code and theme.code=:themeId", Object[].class)
				.setParameter("code", electionCode)
				.setParameter("themeId", themCode)
				.getSingleResult();

		Theme tempTheme = (Theme) pairElectionTheme[1];


		return  tempTheme;

	}

	@Override
	public List<Question> findElectionThemesQuestions(String code, String themeId) {



        Object[] pairElectionTheme = em.createQuery("select election, theme from Election  election  join  election.themes  as theme where election.code =:code and theme.code=:themeId", Object[].class)
                .setParameter("code", code)
                .setParameter("themeId", themeId)
                .getSingleResult();

        Theme tempTheme = (Theme) pairElectionTheme[1];

        return  new ArrayList<Question>(tempTheme.getQuestions());

	}

    @Override
    public Question findElectionThemesQuestionByCode(String code, String themeCode, String questionCode) {

        Object[] pairElectionTheme = em.createQuery("select election, theme from Election  election  join  election.themes  as theme where election.code =:code and theme.code=:themeCode", Object[].class)
                .setParameter("code", code)
                .setParameter("themeCode", themeCode)
                .getSingleResult();

        Theme tempTheme = (Theme) pairElectionTheme[1];
        Set<Question> allThemeQuestions = tempTheme.getQuestions();
        Question result = new Question();


        for (Question next : allThemeQuestions) {

            if (next.getCode().equals(questionCode)) {

                result = next;
            }


        }


        return result;
    }

    @Override
    public void registerElectionThemesQuestions(String code, String themeCode, String questionCode, String questionTitle) {


	    Election foundElection = getElectionByCode(code);
        Theme tempTheme = new Theme();



       Set<Theme> allFoundElectionThemes = foundElection.getThemes();

	    for(Theme next : allFoundElectionThemes)
        {
            if(next.getCode().equals(themeCode)){

                tempTheme = next;
                System.out.println(next.getId());
                System.out.println(next.getCode());
                System.out.println(next.getElectionInfo().getElectionCode());
                System.out.println(next.getElectionInfo().getElectionName());

            }
        }

        Question newQuestion = new Question(questionCode, questionTitle,tempTheme.retrieveThemeInfo(), foundElection.retrieveElectionInfo(), new HashSet<QuestionReponse>());

        Set<Candidature> foundElectionCandidates = foundElection.getCandidatures();
        int numberElectionCandidates = foundElectionCandidates.size();
        Double initialWeight = 100d/numberElectionCandidates;

        Set<QuestionReponse> allQuestionReponses =new HashSet<QuestionReponse>();


        for(Candidature next : foundElectionCandidates){

            QuestionReponse qr = new QuestionReponse(next.getCandidate(), newQuestion, foundElection, initialWeight, 0l,null);
            allQuestionReponses.add(qr);

        }
        newQuestion.setQuestionReponses(allQuestionReponses);
        tempTheme.addNewQuestion(newQuestion);

    }

    @Override
    public void updateElectionThemesQuestionByCode(String code, String themeCode, String questionCode,  List<CandidateCofficientRepresentation> candidatesCofficients) {


	    System.out.println("in updateElectionThemesQuestionByCode");


        Election foundElection = getElectionByCode(code);


        Set<QuestionReponse> electionQuestionsReponses = foundElection.getQuestionReponses();


        for(QuestionReponse nextQuestionReponse : electionQuestionsReponses){

            if(nextQuestionReponse.getQuestion().getCode().equals(questionCode)){

                 for(CandidateCofficientRepresentation nextCandidateCofficientRepresentation : candidatesCofficients){

                     if(nextQuestionReponse.getCandidate().getCandidateId().equals(nextCandidateCofficientRepresentation.getCandidateCode())){

                         nextQuestionReponse.setWeight(nextCandidateCofficientRepresentation.getWeight());

                         System.out.println("in updateElectionThemesQuestionByCode: updating");


                         break;

                     }
                 }

            }
        }
    }

    @Override
    public List<ElectionNameCodeRepresentation>  getAllElections() {

        List<Object[]> allElections =  em.createQuery("select election.code, election.name from Election as election").getResultList();

        List<ElectionNameCodeRepresentation> allElectionNameCodeList = new ArrayList<ElectionNameCodeRepresentation>() ;

        if(allElections!=null){

            for(Object[] nextArrayObject : allElections){

                ElectionNameCodeRepresentation electionNameCodeRepresentation= new ElectionNameCodeRepresentation((String) nextArrayObject[0], (String) nextArrayObject[1]);
                allElectionNameCodeList.add(electionNameCodeRepresentation);


            }
        }
        return  allElectionNameCodeList;
    }




    @Override
    public void updateElectionThemesQuestionResponseWeightForCandidates(String code, List<CandidateCofficientRepresentation> candidatesCofficients) {


        System.out.println("in updateElectionThemesQuestionByCode");


        Election foundElection = getElectionByCode(code);


        Set<QuestionReponse> electionQuestionsReponses = foundElection.getQuestionReponses();


        for(QuestionReponse nextQuestionReponse : electionQuestionsReponses){

                for(CandidateCofficientRepresentation nextCandidateCofficientRepresentation : candidatesCofficients){

                    if(nextQuestionReponse.getCandidate().getCandidateId().equals(nextCandidateCofficientRepresentation.getCandidateCode())){

                        nextQuestionReponse.setWeight(nextCandidateCofficientRepresentation.getWeight());

                        System.out.println("in updateElectionThemesQuestionByCode: updating");
                    }
                }


        }
    }


}
