package com.rrmm.lancecell.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rrmm.lancecell.models.Language;
import com.rrmm.lancecell.repositories.LanguageRepository;

@Service
public class LanguageService {
	@Autowired
	LanguageRepository languageRepository;
	
	public Language create(Language language) {
		return languageRepository.save(language);
	}
	public void delete(Language language) {
		languageRepository.delete(language);
	}
	public Language find(Long id) {
		Optional<Language> opLanguage = languageRepository.findById(id);
		if(opLanguage.isPresent()) {
			return opLanguage.get();
		}
		else {
			return null;
		}
	}
	public Language update(Language language) {
		Optional<Language> opLanguage = languageRepository.findById(language.getId());
		if(opLanguage.isPresent()) {
			return languageRepository.save(language);
		}
		else {
			return null;
		}
		
	}

}
