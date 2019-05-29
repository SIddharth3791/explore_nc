package com.example.ec.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ec.domain.Difficulty;
import com.example.ec.domain.Region;
import com.example.ec.domain.Tour;
import com.example.ec.domain.TourPackage;
import com.example.ec.repo.TourPackageRepository;
import com.example.ec.repo.TourRepository;

@Service
public class TourService {

	private TourPackageRepository tourPackageRepository;
	private TourRepository tourRepository;

	@Autowired
	public TourService(TourPackageRepository tourPackageRepository, TourRepository tourRepository) {
		super();
		this.tourPackageRepository = tourPackageRepository;
		this.tourRepository = tourRepository;
	}
	
	public Tour createTour(Integer id, String title, String description, String blurb, Integer price, String duration,
			String bullets, String keyword, Difficulty difficulty, Region region, String tourPackageCode)
	{
		TourPackage tourPackage = tourPackageRepository.findByName(tourPackageCode);
		if(tourPackage == null)
		{
			throw new RuntimeException("Tour Package Code Does Not Exsist " + tourPackageCode);
		}
		
		
		return tourRepository.save(new Tour(id, title, description, blurb, price, duration, bullets, keyword, difficulty, region, tourPackage));
	}
	

	public Iterable<Tour> lookUp()
	{
		return tourRepository.findAll();
	}
	
	public long total() {
		return tourRepository.count();
	}
}
