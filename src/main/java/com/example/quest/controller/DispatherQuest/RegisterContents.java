package com.example.quest.controller.DispatherQuest;

import com.example.quest.repositories.dispather.DispatcherRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

 public   class RegisterContents  {

     DispatcherRepository dispatcherRepository;

    public RegisterContents(DispatcherRepository dispatcherRepository) {
        this.dispatcherRepository=dispatcherRepository;
    }

     public Map<Integer, ArrayList<String>> getPageContent() {
         Map<Integer, ArrayList<String>> temp=new HashMap<>();
       ArrayList<String> value =new ArrayList<>();
       value.add(dispatcherRepository.getQuestName());
       value.add(dispatcherRepository.getStartPageContent());
       value.add(dispatcherRepository.getVictoryPageContent());
       value.add(String.valueOf(0));
         temp.put(0,value);
         int current=dispatcherRepository.getSetsQuestions().size();
         for (int i = 1; i <=current; i++) {
             ArrayList<String> valueEntry =new ArrayList<>();
             valueEntry.add(dispatcherRepository.getSetsQuestions().get(i));
             valueEntry.add(dispatcherRepository.getSetsAnsversFail().get(i));
             valueEntry.add(dispatcherRepository.getSetsСorrectAnswers().get(i));
             valueEntry.add(dispatcherRepository.getSetsWrongAnswers().get(i));
           temp.put(i,valueEntry);
                  }

         return temp;
     }
 }
