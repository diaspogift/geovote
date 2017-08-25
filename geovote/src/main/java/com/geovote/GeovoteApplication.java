package com.geovote;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.geovote.domain.context.election.*;
import com.geovote.domain.context.result.QuestionReponse;
import com.geovote.services.intf.CandidateService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;

import com.geovote.domain.context.administrative.Constituency;
import com.geovote.domain.context.administrative.District;
import com.geovote.domain.context.administrative.Parish;
import com.geovote.domain.context.administrative.PollingStation;
import com.geovote.domain.context.administrative.SubCounty;
import com.geovote.domain.context.administrative.Voter;
import com.geovote.services.intf.ElectionService;
import com.geovote.services.intf.DistrictService;
import com.geovote.services.intf.VoterService;

@SpringBootApplication
public class GeovoteApplication extends SpringBootServletInitializer {
    public static final double WEIGHT = 100/12;
	
	
	


	@Override
	protected SpringApplicationBuilder  configure(SpringApplicationBuilder application){
		return application.sources(GeovoteApplication.class);
	}


	public static void main(String[] args) {

		ConfigurableApplicationContext container = SpringApplication.run(GeovoteApplication.class, args);
		
		//Services
		ElectionService electionService = container.getBean(ElectionService.class);
        CandidateService candidateService = container.getBean(CandidateService.class);
        DistrictService districtService = container.getBean(DistrictService.class);
        VoterService voterService = container.getBean(VoterService.class);


        //Candidates
		Candidate can1 = new Candidate("can1", "Musakiriza Patrik", new HashSet<Candidature>(),new HashSet<QuestionReponse>());
		Candidate can2 = new Candidate("can2", "Abala David", new HashSet<Candidature>(),new HashSet<QuestionReponse>());
        Candidate can3 = new Candidate("can3", "Ocheng Francis", new HashSet<Candidature>(),new HashSet<QuestionReponse>());
        Candidate can4 = new Candidate("can4", "Opio Simon", new HashSet<Candidature>(),new HashSet<QuestionReponse>());
        Candidate can5 = new Candidate("can5", "Angom Anna", new HashSet<Candidature>(),new HashSet<QuestionReponse>());


        //Elections
        Election election1 = new Election("el1", "2017 Presidential Election", new Date(), new HashSet<Theme>(), new HashSet<Candidature>(), new HashSet<Vote>());
        Election election2 = new Election("el2", "2017 Municipal Election", new Date(), new HashSet<Theme>(), new HashSet<Candidature>(), new HashSet<Vote>());

		//Election's Themes
        Theme th1 = new Theme("th1", "Health",  election1.retrieveElectionInfo(), new HashSet<Question>());
        Theme th2 = new Theme("th2", "Education", election1.retrieveElectionInfo(), new HashSet<Question>());
        Theme th3 = new Theme("th3", "Agriculture", election1.retrieveElectionInfo(), new HashSet<Question>());
        Theme th4 = new Theme("th4", "Security", election1.retrieveElectionInfo(), new HashSet<Question>());
        Theme th5 = new Theme("th5", "Information Technologies", election1.retrieveElectionInfo(), new HashSet<Question>());
        Theme th6 = new Theme("th6", "Economy", election1.retrieveElectionInfo(), new HashSet<Question>());


        Question q1 = new Question("001","What strategy should we adopt for gun violence?", th4.retrieveThemeInfo(), th4.getElectionInfo(), new HashSet<QuestionReponse>());
        Question q2 = new Question("002","What strategy should we adopt for agriculture?", th3.retrieveThemeInfo(), th3.getElectionInfo(),new HashSet<QuestionReponse>());
        Question q3 = new Question("003","Pick the best way to accelarate innovation", th5.retrieveThemeInfo(), th5.getElectionInfo(), new HashSet<QuestionReponse>());
        Question q4 = new Question("004","How should local taxes be handled?", th6.retrieveThemeInfo(), th6.getElectionInfo(),new HashSet<QuestionReponse>());
        Question q5 = new Question("005","How can we make education reflect our traditions?", th2.retrieveThemeInfo(), th2.getElectionInfo(),new HashSet<QuestionReponse>());
        Question q6 = new Question("006","How can we help parents assist their kids better with school?", th2.retrieveThemeInfo(), th2.getElectionInfo(),new HashSet<QuestionReponse>());
        Question q7 = new Question("007","How can we make education boots our economy?", th2.retrieveThemeInfo(), th2.getElectionInfo(),new HashSet<QuestionReponse>());
        Question q8 = new Question("008","What's the best way to fight against AID?", th1.retrieveThemeInfo(), th1.getElectionInfo(),new HashSet<QuestionReponse>());
        Question q9 = new Question("009","How do we prevent juvenile abortions?", th1.retrieveThemeInfo(), th1.getElectionInfo(),new HashSet<QuestionReponse>());
        Question q10 = new Question("010","What steps should we take to modernize Agriculture using IT?", th3.retrieveThemeInfo(), th3.getElectionInfo(),new HashSet<QuestionReponse>());
        Question q11 = new Question("011","How can we significantly reduce violence by reinserting unemployed?", th4.retrieveThemeInfo(), th4.getElectionInfo(),new HashSet<QuestionReponse>());
        Question q12 = new Question("012","What need done for young people to fully take advantage of the evolution of technologies?", th5.retrieveThemeInfo(), th5.getElectionInfo(),new HashSet<QuestionReponse>());


        HashSet<Question> questionsTh1 = new HashSet<Question>();
        questionsTh1.add(q8);
        questionsTh1.add(q9);
        th1.setQuestions(questionsTh1);


        HashSet<Question> questionsTh2 = new HashSet<Question>();
        questionsTh2.add(q5);
        questionsTh2.add(q6);
        questionsTh2.add(q7);
        th2.setQuestions(questionsTh2);

        HashSet<Question> questionsTh3 = new HashSet<Question>();
        questionsTh3.add(q2);
        questionsTh3.add(q10);
        th3.setQuestions(questionsTh3);

        HashSet<Question> questionsTh4 = new HashSet<Question>();
        questionsTh4.add(q1);
        questionsTh4.add(q11);
        th4.setQuestions(questionsTh4);

        HashSet<Question> questionsTh5 = new HashSet<Question>();
        questionsTh5.add(q12);
        questionsTh5.add(q3);
        th5.setQuestions(questionsTh5);

        HashSet<Question> questionsTh6 = new HashSet<Question>();
        questionsTh6.add(q4);
        th6.setQuestions(questionsTh6);


        Set<Theme> themes = new HashSet<Theme>();
		themes.add(th1);
		themes.add(th2);
        themes.add(th3);
        themes.add(th4);
        themes.add(th5);
        themes.add(th6);
		election1.setThemes(themes);

		Set<Theme> themes2 = new HashSet<>();


        election2.setThemes(themes2);
        int i = themes.size() + 1;
        for(Theme nextTheme : themes2){
            nextTheme.setCode(nextTheme.getCode() + "" + i); i ++;
        }







        electionService.createNewElection(election1);
        electionService.createNewElection(election2);


		Candidature candidateOnecandidature = new Candidature(can1,election1,new Date(), "candidate 1 signature");
        Candidature candidateTwocandidature = new Candidature(can2,election1,new Date(), "candidate 2 signature");
        Candidature candidateThreecandidature = new Candidature(can3,election1,new Date(), "candidate 3 signature");
        Candidature candidateFourcandidature = new Candidature(can4,election1,new Date(), "candidate 4 signature");
        Candidature candidateFivecandidature = new Candidature(can5,election1,new Date(), "candidate 5 signature");
//        Candidature candidateSixcandidature = new Candidature(can6,election1,new Date(), "candidate 6 signature");
//        Candidature candidateSevencandidature = new Candidature(can7,election1,new Date(), "candidate 7 signature");
//        Candidature candidate8candidature = new Candidature(can8,election1,new Date(), "candidate 8 signature");
//        Candidature candidate9candidature = new Candidature(can9,election1,new Date(), "candidate 9 signature");
//        Candidature candidate10candidature = new Candidature(can10,election1,new Date(), "candidate 10 signature");


        can1.registerForElection(candidateOnecandidature);
        can2.registerForElection(candidateTwocandidature);
        can3.registerForElection(candidateThreecandidature);
        can4.registerForElection(candidateFourcandidature);
        can5.registerForElection(candidateFivecandidature);
//        can6.registerForElection(candidateSixcandidature);
//        can7.registerForElection(candidateSevencandidature);
//        can8.registerForElection(candidate8candidature);
//        can9.registerForElection(candidate9candidature);
//        can10.registerForElection(candidate10candidature);

            Double total = 100d;
            Double coeff = total/12;
            double weight = WEIGHT;



        QuestionReponse quest1RespCan1 = new QuestionReponse(can1,q1,election1, WEIGHT, 0l,"quest1RespCan1");

        QuestionReponse quest2RespCan1 = new QuestionReponse(can1,q2,election1, weight, 0l,"quest2RespCan1");
        QuestionReponse quest3RespCan1 = new QuestionReponse(can1,q3,election1, weight, 0l,"quest3RespCan1");
        QuestionReponse quest4RespCan1 = new QuestionReponse(can1,q4,election1, weight, 0l, "quest4RespCan1");
        QuestionReponse quest5RespCan1 = new QuestionReponse(can1,q5,election1, weight, 0l, "quest5RespCan1");
        QuestionReponse quest6RespCan1 = new QuestionReponse(can1,q6,election1, weight, 0l, "quest6RespCan1");
        QuestionReponse quest7RespCan1 = new QuestionReponse(can1,q7,election1, weight, 0l, "quest7RespCan1");
        QuestionReponse quest8RespCan1 = new QuestionReponse(can1,q8,election1, weight, 0l, "quest8RespCan1");
        QuestionReponse quest9RespCan1 = new QuestionReponse(can1,q9,election1, weight, 0l, "quest9RespCan1");
        QuestionReponse quest10RespCan1 = new QuestionReponse(can1,q10,election1, weight, 0l, "quest10RespCan1");
        QuestionReponse quest11RespCan1 = new QuestionReponse(can1,q11,election1, weight, 0l, "quest11RespCan1");
        QuestionReponse quest12RespCan1 = new QuestionReponse(can1,q12,election1, weight, 0l, "quest12RespCan1");



        Set<QuestionReponse> allQuestsRespCan1 = new HashSet<QuestionReponse>();


        allQuestsRespCan1.add(quest1RespCan1);
        allQuestsRespCan1.add(quest2RespCan1);
        allQuestsRespCan1.add(quest3RespCan1);
        allQuestsRespCan1.add(quest4RespCan1);
        allQuestsRespCan1.add(quest5RespCan1);
        allQuestsRespCan1.add(quest6RespCan1);
        allQuestsRespCan1.add(quest7RespCan1);
        allQuestsRespCan1.add(quest8RespCan1);
        allQuestsRespCan1.add(quest9RespCan1);
        allQuestsRespCan1.add(quest10RespCan1);
        allQuestsRespCan1.add(quest11RespCan1);
        allQuestsRespCan1.add(quest12RespCan1);




        QuestionReponse quest1RespCan2 = new QuestionReponse(can2,q1,election1, weight, 0l,"quest1RespCan2");
        QuestionReponse quest2RespCan2 = new QuestionReponse(can2,q2,election1, weight, 0l,"quest2RespCan2");
        QuestionReponse quest3RespCan2 = new QuestionReponse(can2,q3,election1, weight, 0l,"quest3RespCan2");
        QuestionReponse quest4RespCan2 = new QuestionReponse(can2,q4,election1, weight, 0l,"quest4RespCan2");
        QuestionReponse quest5RespCan2 = new QuestionReponse(can2,q5,election1, weight, 0l,"quest5RespCan2");
        QuestionReponse quest6RespCan2 = new QuestionReponse(can2,q6,election1, weight, 0l,"quest6RespCan2");
        QuestionReponse quest7RespCan2 = new QuestionReponse(can2,q7,election1, weight, 0l,"quest7RespCan2");
        QuestionReponse quest8RespCan2 = new QuestionReponse(can2,q8,election1, weight, 0l,"quest8RespCan2");
        QuestionReponse quest9RespCan2 = new QuestionReponse(can2,q9,election1, weight, 0l,"quest9RespCan2");
        QuestionReponse quest10RespCan2 = new QuestionReponse(can2,q10,election1, weight, 0l,"quest10RespCan2");
        QuestionReponse quest11RespCan2 = new QuestionReponse(can2,q11,election1, weight, 0l,"quest11RespCan2");
        QuestionReponse quest12RespCan2 = new QuestionReponse(can2,q12,election1, weight, 0l,"quest12RespCan2");

        Set<QuestionReponse> allQuestsRespCan2 = new HashSet<QuestionReponse>();


        allQuestsRespCan2.add(quest1RespCan2);
        allQuestsRespCan2.add(quest2RespCan2);
        allQuestsRespCan2.add(quest3RespCan2);
        allQuestsRespCan2.add(quest4RespCan2);
        allQuestsRespCan2.add(quest5RespCan2);
        allQuestsRespCan2.add(quest6RespCan2);
        allQuestsRespCan2.add(quest7RespCan2);
        allQuestsRespCan2.add(quest8RespCan2);
        allQuestsRespCan2.add(quest9RespCan2);
        allQuestsRespCan2.add(quest10RespCan2);
        allQuestsRespCan2.add(quest11RespCan2);
        allQuestsRespCan2.add(quest12RespCan2);




        QuestionReponse quest1RespCan3 = new QuestionReponse(can3,q1,election1, weight, 0l,"quest1RespCan3");
        QuestionReponse quest2RespCan3 = new QuestionReponse(can3,q2,election1, weight, 0l,"quest2RespCan3");
        QuestionReponse quest3RespCan3 = new QuestionReponse(can3,q3,election1, weight, 0l,"quest3RespCan3");
        QuestionReponse quest4RespCan3 = new QuestionReponse(can3,q4,election1, weight, 0l,"quest4RespCan3");
        QuestionReponse quest5RespCan3 = new QuestionReponse(can3,q5,election1, weight, 0l,"quest5RespCan3");
        QuestionReponse quest6RespCan3 = new QuestionReponse(can3,q6,election1, weight, 0l,"quest6RespCan3");
        QuestionReponse quest7RespCan3 = new QuestionReponse(can3,q7,election1, weight, 0l,"quest7RespCan3");
        QuestionReponse quest8RespCan3 = new QuestionReponse(can3,q8,election1, weight, 0l,"quest8RespCan3");
        QuestionReponse quest9RespCan3 = new QuestionReponse(can3,q9,election1, weight, 0l,"quest9RespCan3");
        QuestionReponse quest10RespCan3 = new QuestionReponse(can3,q10,election1, weight, 0l,"quest10RespCan3");
        QuestionReponse quest11RespCan3 = new QuestionReponse(can3,q11,election1, weight, 0l,"quest11RespCan3");
        QuestionReponse quest12RespCan3 = new QuestionReponse(can3,q12,election1, weight, 0l,"quest12RespCan3");

        Set<QuestionReponse> allQuestsRespCan3 = new HashSet<QuestionReponse>();


        allQuestsRespCan3.add(quest1RespCan3);
        allQuestsRespCan3.add(quest2RespCan3);
        allQuestsRespCan3.add(quest3RespCan3);
        allQuestsRespCan3.add(quest4RespCan3);
        allQuestsRespCan3.add(quest5RespCan3);
        allQuestsRespCan3.add(quest6RespCan3);
        allQuestsRespCan3.add(quest7RespCan3);
        allQuestsRespCan3.add(quest8RespCan3);
        allQuestsRespCan3.add(quest9RespCan3);
        allQuestsRespCan3.add(quest10RespCan3);
        allQuestsRespCan3.add(quest11RespCan3);
        allQuestsRespCan3.add(quest12RespCan3);



        QuestionReponse quest1RespCan4 = new QuestionReponse(can4,q1,election1, weight, 0l,"quest1RespCan4");
        QuestionReponse quest2RespCan4 = new QuestionReponse(can4,q2,election1, weight, 0l,"quest2RespCan4");
        QuestionReponse quest3RespCan4 = new QuestionReponse(can4,q3,election1, weight, 0l,"quest3RespCan4");
        QuestionReponse quest4RespCan4 = new QuestionReponse(can4,q4,election1, weight, 0l,"quest4RespCan4");
        QuestionReponse quest5RespCan4 = new QuestionReponse(can4,q5,election1, weight, 0l,"quest5RespCan4");
        QuestionReponse quest6RespCan4 = new QuestionReponse(can4,q6,election1, weight, 0l,"quest6RespCan4");
        QuestionReponse quest7RespCan4 = new QuestionReponse(can4,q7,election1, weight, 0l,"quest7RespCan4");
        QuestionReponse quest8RespCan4 = new QuestionReponse(can4,q8,election1, weight, 0l,"quest8RespCan4");
        QuestionReponse quest9RespCan4 = new QuestionReponse(can4,q9,election1, weight, 0l,"quest9RespCan4");
        QuestionReponse quest10RespCan4 = new QuestionReponse(can4,q10,election1, weight, 0l,"quest10RespCan4");
        QuestionReponse quest11RespCan4 = new QuestionReponse(can4,q11,election1, weight, 0l,"quest11RespCan4");
        QuestionReponse quest12RespCan4 = new QuestionReponse(can4,q12,election1, weight, 0l,"quest12RespCan4");

        Set<QuestionReponse> allQuestsRespCan4 = new HashSet<QuestionReponse>();


        allQuestsRespCan4.add(quest1RespCan4);
        allQuestsRespCan4.add(quest2RespCan4);
        allQuestsRespCan4.add(quest3RespCan4);
        allQuestsRespCan4.add(quest4RespCan4);
        allQuestsRespCan4.add(quest5RespCan4);
        allQuestsRespCan4.add(quest6RespCan4);
        allQuestsRespCan4.add(quest7RespCan4);
        allQuestsRespCan4.add(quest8RespCan4);
        allQuestsRespCan4.add(quest9RespCan4);
        allQuestsRespCan4.add(quest10RespCan4);
        allQuestsRespCan4.add(quest11RespCan4);
        allQuestsRespCan4.add(quest12RespCan4);



        QuestionReponse quest1RespCan5 = new QuestionReponse(can5,q1,election1, weight, 0l,"quest1RespCan5");
        QuestionReponse quest2RespCan5 = new QuestionReponse(can5,q2,election1, weight, 0l,"quest2RespCan5");
        QuestionReponse quest3RespCan5 = new QuestionReponse(can5,q3,election1, weight, 0l,"quest3RespCan5");
        QuestionReponse quest4RespCan5 = new QuestionReponse(can5,q4,election1, weight, 0l,"quest4RespCan5");
        QuestionReponse quest5RespCan5 = new QuestionReponse(can5,q5,election1, weight, 0l,"quest5RespCan5");
        QuestionReponse quest6RespCan5 = new QuestionReponse(can5,q6,election1, weight, 0l,"quest6RespCan5");
        QuestionReponse quest7RespCan5 = new QuestionReponse(can5,q7,election1, weight, 0l,"quest7RespCan5");
        QuestionReponse quest8RespCan5 = new QuestionReponse(can5,q8,election1, weight, 0l,"quest8RespCan5");
        QuestionReponse quest9RespCan5 = new QuestionReponse(can5,q9,election1, weight, 0l,"quest9RespCan5");
        QuestionReponse quest10RespCan5 = new QuestionReponse(can5,q10,election1, weight, 0l,"quest10RespCan5");
        QuestionReponse quest11RespCan5 = new QuestionReponse(can5,q11,election1, weight, 0l,"quest11RespCan5");
        QuestionReponse quest12RespCan5 = new QuestionReponse(can5,q12,election1, weight, 0l,"quest12RespCan5");

        Set<QuestionReponse> allQuestsRespCan5 = new HashSet<QuestionReponse>();


        allQuestsRespCan5.add(quest1RespCan5);
        allQuestsRespCan5.add(quest2RespCan5);
        allQuestsRespCan5.add(quest3RespCan5);
        allQuestsRespCan5.add(quest4RespCan5);
        allQuestsRespCan5.add(quest5RespCan5);
        allQuestsRespCan5.add(quest6RespCan5);
        allQuestsRespCan5.add(quest7RespCan5);
        allQuestsRespCan5.add(quest8RespCan5);
        allQuestsRespCan5.add(quest9RespCan5);
        allQuestsRespCan5.add(quest10RespCan5);
        allQuestsRespCan5.add(quest11RespCan5);
        allQuestsRespCan5.add(quest12RespCan5);

        can1.setQuestionReponses(allQuestsRespCan1);
        can2.setQuestionReponses(allQuestsRespCan2);
        can3.setQuestionReponses(allQuestsRespCan3);
        can4.setQuestionReponses(allQuestsRespCan4);
        can5.setQuestionReponses(allQuestsRespCan5);

        candidateService.createNewCandidate(can1);
		candidateService.createNewCandidate(can2);
        candidateService.createNewCandidate(can3);
        candidateService.createNewCandidate(can4);
        candidateService.createNewCandidate(can5);



        PollingStation ps1 = new PollingStation("ps_1", "01-RAILWAY PARK", 4.0704429, 9.7243475);
		ps1.setTotalVoters(20l);
		ps1.setCurrentVotes(0l);
		PollingStation ps2 = new PollingStation("ps_2", "02-NATIONAL THEATRE", 0d,0d);
		ps2.setTotalVoters(30l);
		ps2.setCurrentVotes(0l);
		HashSet<PollingStation> pollsta1 = new HashSet<PollingStation>();
		pollsta1.add(ps1);
		pollsta1.add(ps2);


		PollingStation ps3 = new PollingStation("ps_3", "01-BAPTIST CHURCH");
		ps3.setTotalVoters(50l);
		ps3.setCurrentVotes(0l);
		PollingStation ps4 = new PollingStation("ps_4", "02-HOIMA ROAD FLATS");
		ps4.setTotalVoters(15l);
		ps4.setCurrentVotes(0l);
        PollingStation ps5 = new PollingStation("ps_5", "03-KAKAJO I ZONE");
        ps5.setTotalVoters(40l);
        ps5.setCurrentVotes(0l);
        PollingStation ps6 = new PollingStation("ps_6", "04-KAKAJO II ZONE [A-M]");
        ps6.setTotalVoters(25l);
        ps6.setCurrentVotes(0l);
        PollingStation ps7 = new PollingStation("ps_7", "05-HAJJ KATENDE'S HOME");
        ps7.setTotalVoters(12l);
        ps7.setCurrentVotes(0l);
        PollingStation ps8 = new PollingStation("ps_8", "06-KIYINDI MOSQUE");
        ps8.setTotalVoters(30l);
        ps8.setCurrentVotes(0l);
        PollingStation ps9 = new PollingStation("ps_9", "07-NAMALWA I ZONE");
        ps9.setTotalVoters(22l);
        ps9.setCurrentVotes(0l);
        PollingStation ps10 = new PollingStation("ps_10", "08-NAMALWA II ZONE");
        ps10.setTotalVoters(32l);
        ps10.setCurrentVotes(0l);
        PollingStation ps11 = new PollingStation("ps_11", "09-MUTI BAY CAR WASHING BAY");
        ps11.setTotalVoters(16l);
        ps11.setCurrentVotes(0l);
        PollingStation ps12 = new PollingStation("ps_12", "10-KAKAJO II ZONE [N-Z]");
        ps12.setTotalVoters(50l);
        ps12.setCurrentVotes(0l);



		HashSet<PollingStation> pollsta2 = new HashSet<PollingStation>();
		pollsta2.add(ps3);
		pollsta2.add(ps4);
        pollsta2.add(ps5);
        pollsta2.add(ps6);
        pollsta2.add(ps7);
        pollsta2.add(ps8);
        pollsta2.add(ps9);
        pollsta2.add(ps10);
        pollsta2.add(ps11);
        pollsta2.add(ps12);


		Parish p1 = new Parish("par_1", "Bukesa",pollsta2);

		Parish p2 = new Parish("par_2", "Civic Centre", pollsta1);

		Parish p3 = new Parish("par_3", "Banda", pollsta2);

		Parish p4 = new Parish("par_4", "Bujumba",new HashSet<PollingStation>());

        Parish p5 = new Parish("par_5", "Kayunga", new HashSet<PollingStation>());

        Parish p6 = new Parish("par_6", "Bubeke", new HashSet<PollingStation>());

        Parish p7 = new Parish("par_7", "Bufumira", new HashSet<PollingStation>());

        Parish p8 = new Parish("par_8", "Aninata", new HashSet<PollingStation>());

        Parish p9 = new Parish("par_9", "Adea", new HashSet<PollingStation>());

        Parish p10 = new Parish("par_10", "Pukony", new HashSet<PollingStation>());

        Parish p11 = new Parish("par_11", "Mede", new HashSet<PollingStation>());

        Parish p12 = new Parish("par_12", "Iriaga", new HashSet<PollingStation>());

        Parish p13 = new Parish("par_13", "Techo", new HashSet<PollingStation>());







        HashSet<Parish> pa1 = new HashSet<Parish>();
		pa1.add(p1);
		pa1.add(p2);

		HashSet<Parish> pa2 = new HashSet<Parish>();
		pa2.add(p3);

        HashSet<Parish> pa3 = new HashSet<Parish>();
        pa3.add(p4);

        HashSet<Parish> pa4 = new HashSet<Parish>();
        pa4.add(p5);

        HashSet<Parish> pa5 = new HashSet<Parish>();
        pa5.add(p6);

        HashSet<Parish> pa6 = new HashSet<Parish>();
        pa6.add(p7);

        HashSet<Parish> pa7 = new HashSet<Parish>();
        pa7.add(p8);

        HashSet<Parish> pa8 = new HashSet<Parish>();
        pa8.add(p9);



        HashSet<Parish> pa9 = new HashSet<Parish>();
        pa9.add(p10);

        HashSet<Parish> pa10 = new HashSet<Parish>();
        pa10.add(p11);


        HashSet<Parish> pa11 = new HashSet<Parish>();
        pa11.add(p12);

        HashSet<Parish> pa12 = new HashSet<Parish>();
        pa12.add(p13);






		SubCounty subCo1 = new SubCounty("sbc_1", "Kampala Central", pa1);
		SubCounty subCo2 = new SubCounty("sbc_2", "Nakawa", pa2);


        SubCounty subCo3 = new SubCounty("sbc_3", "Bubeke", pa5);
        SubCounty subCo4 = new SubCounty("sbc_4", "Bufumira", pa3);

        SubCounty subCo5 = new SubCounty("sbc_5", "Bujumba", pa6);
        SubCounty subCo6 = new SubCounty("sbc_6", "Mugoye", pa4);

        SubCounty subCo7 = new SubCounty("sbc_7", "Abim", pa7);
        SubCounty subCo8 = new SubCounty("sbc_8", "Murulem", pa8);

        SubCounty subCo9 = new SubCounty("sbc_9", "Awach", pa9);
        SubCounty subCo10 = new SubCounty("sbc_10", "Palaro", pa10);

        SubCounty subCo11 = new SubCounty("sbc_11", "Laroo", pa11);
        SubCounty subCo12 = new SubCounty("sbc_12", "Layibi", pa12);


		HashSet<SubCounty> subCol1 = new HashSet<SubCounty>();
		subCol1.add(subCo1);

		HashSet<SubCounty> subCol2 = new HashSet<SubCounty>();
		subCol2.add(subCo2);

        HashSet<SubCounty> subCol3 = new HashSet<SubCounty>();
        subCol3.add(subCo3);
        subCol3.add(subCo4);

        HashSet<SubCounty> subCol4 = new HashSet<SubCounty>();
        subCol4.add(subCo5);
        subCol4.add(subCo6);

        HashSet<SubCounty> subCol5 = new HashSet<SubCounty>();
        subCol5.add(subCo7);
        subCol5.add(subCo8);

        HashSet<SubCounty> subCol6 = new HashSet<SubCounty>();
        subCol6.add(subCo9);
        subCol6.add(subCo10);

        HashSet<SubCounty> subCol7 = new HashSet<SubCounty>();
        subCol7.add(subCo11);
        subCol7.add(subCo12);

		Constituency c1 = new Constituency("cons_1", "Kampala Central Division", subCol1);
		Constituency c2 = new Constituency("cons_2", "Nakawa Division", subCol2);


		Constituency c3 = new Constituency("cons_3", "Bujumba County", subCol4);
		Constituency c4 = new Constituency("cons_4", "Kyamuswa County", subCol3);
        Constituency c5 = new Constituency("cons_5", "Labwor County", subCol5);
        Constituency c6 = new Constituency("cons_6", "Aswa County", subCol6);
        Constituency c7 = new Constituency("cons_7", "Gulu Municipality", subCol7);


        HashSet<Constituency> constL1 = new HashSet<Constituency>();
		constL1.add(c1);
		constL1.add(c2);

		HashSet<Constituency> constL2 = new HashSet<Constituency>();
		constL2.add(c3);
		constL2.add(c4);

        HashSet<Constituency> constL3 = new HashSet<Constituency>();
        constL3.add(c5);


        HashSet<Constituency> constL4 = new HashSet<Constituency>();
        constL4.add(c6);
        constL4.add(c7);

		District di1 = new District("dist_1", "Kampala", constL1);
		District di2 = new District("dist_2", "Kalangala", constL2);
        District di3 = new District("dist_3", "Abim", constL3);
        District di4 = new District("dist_4", "Gulu", constL4);

		districtService.createNewDistrict(di1);
		districtService.createNewDistrict(di2);
        districtService.createNewDistrict(di3);
        districtService.createNewDistrict(di4);
		
	

		Voter vo1 = new Voter("app_id_1", "001", "Fotio", "Felicien", new Date(), "M", "Bonaberi","",
				new Date(), di1.retrieveBasicInfo(), c1.retrieveBasicInfo(), p1.retrieveBasicInfo(), ps3.retrieveBasicInfo(),
				subCo1.retrieveBasicInfo(),new HashSet<>());

		Voter vo2 = new Voter("app_id_2", "002", "Puepi", "Herve", new Date(), "M", "Bonamoussadi","",
				new Date(),  di1.retrieveBasicInfo(), c1.retrieveBasicInfo(), p1.retrieveBasicInfo(), ps4.retrieveBasicInfo(),
				subCo1.retrieveBasicInfo(), new HashSet<>());

		Voter vo3 = new Voter("app_id_3", "003", "Hess", "Megan", new Date(), "F", "Denver","",
				new Date(),di1.retrieveBasicInfo(), c1.retrieveBasicInfo(), p1.retrieveBasicInfo(), ps5.retrieveBasicInfo(),
				subCo1.retrieveBasicInfo(),new HashSet<>());

		Voter vo4 = new Voter("app_id_4", "004", "Fothe", "Fabrice", new Date(), "M", "Paris","",
				new Date(),di1.retrieveBasicInfo(), c1.retrieveBasicInfo(), p1.retrieveBasicInfo(), ps4.retrieveBasicInfo(),
				subCo1.retrieveBasicInfo(), new HashSet<>());
        Voter vo5 = new Voter("app_id_5", "005", "Abaho", "Elise", new Date(), "M", "Bonaberi","",
                new Date(), di1.retrieveBasicInfo(), c1.retrieveBasicInfo(), p1.retrieveBasicInfo(), ps12.retrieveBasicInfo(),
                subCo1.retrieveBasicInfo(),new HashSet<>());

        Voter vo6 = new Voter("app_id_6", "006", "Abadaka", "Nora", new Date(), "M", "Bonamoussadi","",
                new Date(),  di1.retrieveBasicInfo(), c1.retrieveBasicInfo(), p1.retrieveBasicInfo(), ps10.retrieveBasicInfo(),
                subCo1.retrieveBasicInfo(), new HashSet<>());

        Voter vo7 = new Voter("app_id_7", "007", "Alouma", "Salime", new Date(), "F", "Denver","",
                new Date(),di1.retrieveBasicInfo(), c1.retrieveBasicInfo(), p1.retrieveBasicInfo(), ps12.retrieveBasicInfo(),
                subCo1.retrieveBasicInfo(),new HashSet<>());

        Voter vo8 = new Voter("app_id_8", "008", "Babito", "Nassir", new Date(), "M", "Paris","",
                new Date(),di1.retrieveBasicInfo(), c1.retrieveBasicInfo(), p1.retrieveBasicInfo(), ps4.retrieveBasicInfo(),
                subCo1.retrieveBasicInfo(), new HashSet<>());
        Voter vo9 = new Voter("app_id_9", "009", "Batenga", "Florence", new Date(), "F", "Bonaberi","",
                new Date(), di1.retrieveBasicInfo(), c1.retrieveBasicInfo(), p1.retrieveBasicInfo(), ps5.retrieveBasicInfo(),
                subCo1.retrieveBasicInfo(),new HashSet<>());

        Voter vo10 = new Voter("app_id_10", "010", "Berounda", "Wilfried", new Date(), "M", "Bonamoussadi","",
                new Date(),  di1.retrieveBasicInfo(), c1.retrieveBasicInfo(), p1.retrieveBasicInfo(), ps3.retrieveBasicInfo(),
                subCo1.retrieveBasicInfo(), new HashSet<>());

        Voter vo11 = new Voter("app_id_11", "011", "Bousingue", "Pascal", new Date(), "M", "Denver","",
                new Date(),di1.retrieveBasicInfo(), c1.retrieveBasicInfo(), p1.retrieveBasicInfo(), ps3.retrieveBasicInfo(),
                subCo1.retrieveBasicInfo(),new HashSet<>());

        Voter vo12 = new Voter("app_id_12", "012", "Ndele", "Chamine", new Date(), "M", "Paris","",
                new Date(),di1.retrieveBasicInfo(), c1.retrieveBasicInfo(), p1.retrieveBasicInfo(), ps10.retrieveBasicInfo(),
                subCo1.retrieveBasicInfo(), new HashSet<>());
        Voter vo13 = new Voter("app_id_13", "013", "Ndoukou", "John", new Date(), "M", "Bonaberi","",
                new Date(), di1.retrieveBasicInfo(), c1.retrieveBasicInfo(), p1.retrieveBasicInfo(), ps11.retrieveBasicInfo(),
                subCo1.retrieveBasicInfo(),new HashSet<>());

        Voter vo14 = new Voter("app_id_14", "014", "Epila", "Alfred", new Date(), "M", "Bonamoussadi","",
                new Date(),  di1.retrieveBasicInfo(), c1.retrieveBasicInfo(), p1.retrieveBasicInfo(), ps12.retrieveBasicInfo(),
                subCo1.retrieveBasicInfo(), new HashSet<>());

        Voter vo15 = new Voter("app_id_15", "015", "Fatouma", "Abdou", new Date(), "F", "Denver","",
                new Date(),di1.retrieveBasicInfo(), c1.retrieveBasicInfo(), p1.retrieveBasicInfo(), ps3.retrieveBasicInfo(),
                subCo1.retrieveBasicInfo(),new HashSet<>());

        Voter vo16 = new Voter("app_id_16", "016", "Happy", "Bright", new Date(), "M", "Paris","",
                new Date(),di1.retrieveBasicInfo(), c1.retrieveBasicInfo(), p1.retrieveBasicInfo(), ps4.retrieveBasicInfo(),
                subCo1.retrieveBasicInfo(), new HashSet<>());
        Voter vo17 = new Voter("app_id_17", "017", "Goza", "Pauline", new Date(), "M", "Bonaberi","",
                new Date(), di1.retrieveBasicInfo(), c1.retrieveBasicInfo(), p2.retrieveBasicInfo(), ps1.retrieveBasicInfo(),
                subCo1.retrieveBasicInfo(),new HashSet<>());

        Voter vo18 = new Voter("app_id_18", "018", "Kabega", "Constance", new Date(), "M", "Bonamoussadi","",
                new Date(),  di1.retrieveBasicInfo(), c1.retrieveBasicInfo(), p2.retrieveBasicInfo(), ps2.retrieveBasicInfo(),
                subCo1.retrieveBasicInfo(), new HashSet<>());

        Voter vo19 = new Voter("app_id_19", "019", "Kabousa", "Peter", new Date(), "F", "Denver","",
                new Date(),di1.retrieveBasicInfo(), c1.retrieveBasicInfo(), p2.retrieveBasicInfo(), ps2.retrieveBasicInfo(),
                subCo1.retrieveBasicInfo(),new HashSet<>());

        Voter vo20 = new Voter("app_id_20", "020", "Kazoule", "Badrou", new Date(), "M", "Paris","",
                new Date(),di1.retrieveBasicInfo(), c1.retrieveBasicInfo(), p2.retrieveBasicInfo(), ps1.retrieveBasicInfo(),
                subCo1.retrieveBasicInfo(), new HashSet<>());
        Voter vo21 = new Voter("app_id_21", "021", "Noule", "Patrik", new Date(), "M", "Bonaberi","",
                new Date(), di1.retrieveBasicInfo(), c1.retrieveBasicInfo(), p2.retrieveBasicInfo(), ps1.retrieveBasicInfo(),
                subCo1.retrieveBasicInfo(),new HashSet<>());

        Voter vo22 = new Voter("app_id_22", "022", "Babasit", "Sandra", new Date(), "M", "Bonamoussadi","",
                new Date(),  di1.retrieveBasicInfo(), c1.retrieveBasicInfo(), p2.retrieveBasicInfo(), ps2.retrieveBasicInfo(),
                subCo1.retrieveBasicInfo(), new HashSet<>());

        Voter vo23 = new Voter("app_id_23", "023", "Moubirou", "Mozes", new Date(), "F", "Denver","",
                new Date(),di1.retrieveBasicInfo(), c1.retrieveBasicInfo(), p2.retrieveBasicInfo(), ps2.retrieveBasicInfo(),
                subCo1.retrieveBasicInfo(),new HashSet<>());

        Voter vo24 = new Voter("app_id_24", "024", "Moujissa", "Ivan", new Date(), "M", "Paris","",
                new Date(),di1.retrieveBasicInfo(), c1.retrieveBasicInfo(), p2.retrieveBasicInfo(), ps1.retrieveBasicInfo(),
                subCo1.retrieveBasicInfo(), new HashSet<>());
        Voter vo25 = new Voter("app_id_25", "025", "Naboubousi", "Justine", new Date(), "F", "Paris","",
                new Date(),di1.retrieveBasicInfo(), c1.retrieveBasicInfo(), p2.retrieveBasicInfo(), ps1.retrieveBasicInfo(),
                subCo1.retrieveBasicInfo(), new HashSet<>());


        voterService.createNewVoter(vo1);
		voterService.createNewVoter(vo2);
		voterService.createNewVoter(vo3);
		voterService.createNewVoter(vo4);
        voterService.createNewVoter(vo5);
        voterService.createNewVoter(vo6);
        voterService.createNewVoter(vo7);
        voterService.createNewVoter(vo8);
        voterService.createNewVoter(vo9);
        voterService.createNewVoter(vo10);
        voterService.createNewVoter(vo11);
        voterService.createNewVoter(vo12);
        voterService.createNewVoter(vo13);
        voterService.createNewVoter(vo14);
        voterService.createNewVoter(vo15);
        voterService.createNewVoter(vo16);
        voterService.createNewVoter(vo17);
        voterService.createNewVoter(vo18);
        voterService.createNewVoter(vo19);
        voterService.createNewVoter(vo20);
        voterService.createNewVoter(vo21);
        voterService.createNewVoter(vo22);
        voterService.createNewVoter(vo23);
        voterService.createNewVoter(vo24);
        voterService.createNewVoter(vo25);


        Vote vote1 = new Vote(vo1, election1, new Date(), "signature_voter1");
		vo1.getVotes().add(vote1);

		Vote vote2 = new Vote(vo2, election1, new Date(), "signature_voter2");
		vo2.getVotes().add(vote2);

		Vote vote3 = new Vote(vo3, election1,new Date(), "signature_voter3");
		vo3.getVotes().add(vote3);

		Vote vote4 = new Vote(vo4, election1, new Date(), "signature_voter4");
		vo4.getVotes().add(vote4);

        Vote vote5 = new Vote(vo5, election1, new Date(), "signature_voter4");
        vo5.getVotes().add(vote5);

        Vote vote6 = new Vote(vo6, election1, new Date(), "signature_voter4");
        vo6.getVotes().add(vote6);

        Vote vote7 = new Vote(vo7, election1, new Date(), "signature_voter4");
        vo7.getVotes().add(vote7);

        Vote vote8 = new Vote(vo8, election1, new Date(), "signature_voter4");
        vo8.getVotes().add(vote8);

        Vote vote9 = new Vote(vo9, election1, new Date(), "signature_voter4");
        vo9.getVotes().add(vote9);

        Vote vote10 = new Vote(vo10, election1, new Date(), "signature_voter4");
        vo10.getVotes().add(vote10);

        Vote vote11 = new Vote(vo11, election1, new Date(), "signature_voter4");
        vo11.getVotes().add(vote11);

        Vote vote12 = new Vote(vo12, election1, new Date(), "signature_voter4");
        vo12.getVotes().add(vote12);

        Vote vote13 = new Vote(vo13, election1, new Date(), "signature_voter4");
        vo13.getVotes().add(vote13);

        Vote vote14 = new Vote(vo14, election1, new Date(), "signature_voter4");
        vo14.getVotes().add(vote14);

        Vote vote15 = new Vote(vo15, election1, new Date(), "signature_voter4");
        vo15.getVotes().add(vote15);

        Vote vote16  = new Vote(vo16, election1, new Date(), "signature_voter4");
        vo16.getVotes().add(vote16);

        Vote vote17 = new Vote(vo17, election1, new Date(), "signature_voter4");
        vo17.getVotes().add(vote17);

        Vote vote18 = new Vote(vo18, election1, new Date(), "signature_voter4");
        vo18.getVotes().add(vote18);

        Vote vote19 = new Vote(vo19, election1, new Date(), "signature_voter4");
        vo19.getVotes().add(vote19);

        Vote vote20 = new Vote(vo20, election1, new Date(), "signature_voter4");
        vo20.getVotes().add(vote20);

        Vote vote21 = new Vote(vo21, election1, new Date(), "signature_voter4");
        vo21.getVotes().add(vote21);

        Vote vote22 = new Vote(vo22, election1, new Date(), "signature_voter4");
        vo22.getVotes().add(vote22);

        Vote vote23 = new Vote(vo23, election1, new Date(), "signature_voter4");
        vo23.getVotes().add(vote23);

        Vote vote24 = new Vote(vo24, election1, new Date(), "signature_voter4");
        vo24.getVotes().add(vote24);

        Vote vote25 = new Vote(vo25, election1, new Date(), "signature_voter4");
        vo25.getVotes().add(vote25);




		

	}
}
