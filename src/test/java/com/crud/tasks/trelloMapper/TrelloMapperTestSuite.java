package com.crud.tasks.trelloMapper;

import com.crud.tasks.domain.TrelloBoard;
import com.crud.tasks.domain.TrelloCard;
import com.crud.tasks.domain.TrelloList;
import com.crud.tasks.dto.TrelloBoardDto;
import com.crud.tasks.dto.TrelloCardDto;
import com.crud.tasks.dto.TrelloListDto;
import com.crud.tasks.mapper.TrelloMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TrelloMapperTestSuite {

    @Autowired
    private TrelloMapper trelloMapper;

    @Test
    void testMapToBoards() {
        //Given
        TrelloListDto listDto = new TrelloListDto("1", "list one", true);
        TrelloBoardDto boardDto = new TrelloBoardDto("2", "board one", new ArrayList<>(Arrays.asList(listDto)));
        List<TrelloBoardDto> boardDtoList = new ArrayList<>(Arrays.asList(boardDto));

        //When
        List<TrelloBoard> mappedList = trelloMapper.mapToBoards(boardDtoList);

        //Then
        assertEquals(mappedList.get(0).getClass(), TrelloBoard.class);
        assertEquals("2", mappedList.get(0).getId());
        assertEquals("board one", mappedList.get(0).getName());
        assertEquals("1", mappedList.get(0).getLists().get(0).getId());
        assertEquals("list one", mappedList.get(0).getLists().get(0).getName());
        Assertions.assertTrue(mappedList.get(0).getLists().get(0).isClosed());
    }

    @Test
    void testMapToBoardsDto() {
        //Given
        TrelloList list = new TrelloList("1", "list one", true);
        TrelloBoard board = new TrelloBoard("2", "board one", new ArrayList<>(Arrays.asList(list)));
        List<TrelloBoard> boardList = new ArrayList<>(Arrays.asList(board));

        //When
        List<TrelloBoardDto> mappedList = trelloMapper.mapToBoardsDto(boardList);

        //Then
        assertEquals(mappedList.get(0).getClass(), TrelloBoardDto.class);
        assertEquals("2", mappedList.get(0).getId());
        assertEquals("board one", mappedList.get(0).getName());
        assertEquals("1", mappedList.get(0).getLists().get(0).getId());
        assertEquals("list one", mappedList.get(0).getLists().get(0).getName());
        Assertions.assertTrue(mappedList.get(0).getLists().get(0).isClosed());
    }

    @Test
    void testMapToList() {
        //Given
        TrelloListDto listDto = new TrelloListDto("1", "list one", true);

        //When
        List<TrelloList> mappedList = trelloMapper.mapToList(Arrays.asList(listDto));

        //Then
        assertEquals(mappedList.get(0).getClass(), TrelloList.class);
        assertEquals("1", mappedList.get(0).getId());
        assertEquals("list one", mappedList.get(0).getName());
        Assertions.assertTrue(mappedList.get(0).isClosed());
    }

    @Test
    void testMapToListDto() {
        //Given
        TrelloList list = new TrelloList("1", "list one", true);

        //When
        List<TrelloListDto> mappedList = trelloMapper.mapToListDto(Arrays.asList(list));

        //Then
        assertEquals(mappedList.get(0).getClass(), TrelloListDto.class);
        assertEquals("1", mappedList.get(0).getId());
        assertEquals("list one", mappedList.get(0).getName());
        Assertions.assertTrue(mappedList.get(0).isClosed());
    }

    @Test
    void testMapToCard() {
        //Given
        TrelloCardDto cardDto = new TrelloCardDto("1", "name", "description", "top");

        //When
        TrelloCard mappedCard = trelloMapper.mapToCard(cardDto);

        //Then
        assertEquals(mappedCard.getClass(), TrelloCard.class);
        assertEquals("1", mappedCard.getListId());
        assertEquals("name", mappedCard.getName());
        assertEquals("description", mappedCard.getDescription());
        assertEquals("top", mappedCard.getPos());
    }

    @Test
    void testMapToCardDto() {
        //Given
        TrelloCard card = new TrelloCard("name", "description", "top", "1");

        //When
        TrelloCardDto mappedCard = trelloMapper.mapToCardDto(card);

        //Then
        assertEquals(mappedCard.getClass(), TrelloCardDto.class);
        assertEquals("1", mappedCard.getListId());
        assertEquals("name", mappedCard.getTaskName());
        assertEquals("description", mappedCard.getTaskDescription());
        assertEquals("top", mappedCard.getTaskDisplayPosition());
    }
}
