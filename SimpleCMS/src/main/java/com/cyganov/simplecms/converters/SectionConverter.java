package com.cyganov.simplecms.converters;

import com.cyganov.simplecms.domain.Section;
import com.cyganov.simplecms.domain.dto.SectionDto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Tsyhanou Siarhei
 * Date: 22.08.13
 * Time: 11:18
 */
public class SectionConverter {

	public static Section DtoToSection(SectionDto sectionDto){
		Section section = new Section();
		section.setDate(sectionDto.getDate());
		section.setId(sectionDto.getId());
		section.setName(sectionDto.getName());
		section.setContent(sectionDto.getContent());
		section.setPublished(sectionDto.isPublished());
		return section;
	}

	public static SectionDto SectionToDto(Section section){
		SectionDto sectionDto = new SectionDto();
		sectionDto.setName(section.getName());
		sectionDto.setDate(section.getDate());
		sectionDto.setId(section.getId());
		sectionDto.setPublished(section.isPublished());
		sectionDto.setContent(section.getContent());

		SectionDto parent = null;
		if (section.getParent() != null){
			parent = SectionToDto(section.getParent());
		}
		sectionDto.setParent(parent);
		return sectionDto;
	}

	public static SectionDto SectionToDto(Section section, SectionDto parent){
		SectionDto sectionDto = new SectionDto();
		sectionDto.setName(section.getName());
		sectionDto.setDate(section.getDate());
		sectionDto.setId(section.getId());
		sectionDto.setPublished(section.isPublished());
		sectionDto.setContent(section.getContent());
		sectionDto.setParent(parent);

		List<SectionDto> sectionDtoList = new ArrayList<SectionDto>();
		if (section.getChildren().size() != 0){
			for (Section item : section.getChildren()){
				sectionDtoList.add(SectionToDto(item, sectionDto));
			}
		}
		sectionDto.setChildren(sectionDtoList);

		return sectionDto;
	}

	public static List<SectionDto> getSectionDtoList(List<Section> list){
		List<SectionDto> sectionList = new ArrayList<SectionDto>();
		for (Section section : list){
			sectionList.add(SectionConverter.SectionToDto(section, null));
		}
		return sectionList;
	}

}
