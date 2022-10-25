package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GameStoreTest {

    @Test
    public void shouldAddGame() {

        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        assertTrue(store.containsGame(game));
    }

    // другие ваши тесты
    @Test
    public void playedTimeTest() {

        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player = new Player("Andrei");
        player.installGame(game);
        player.play(game, 1);

        int expected = 1;
        int actual = store.getSumPlayedTime();

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void addPlayTimeTest() {

        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player = new Player("Andrei");
        player.installGame(game);
        player.play(game, 1);
        store.addPlayTime("Andrei", 2);

        int expected = 3;
        int actual = store.getSumPlayedTime();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void mostPlayedPlayerTest() {

        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player1 = new Player("Andrei");
        Player player2 = new Player("Evgenia");
        player1.installGame(game);
        player1.play(game, 1);
        player2.installGame(game);
        player2.play(game, 2);

        String expected = "Evgenia";
        String actual = store.getMostPlayer();

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void sumPlayedTimeTest() {

        GameStore store = new GameStore();
        Game game1 = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game2 = store.publishGame("Кольца", "Аркады");

        Player player1 = new Player("Andrei");
        Player player2 = new Player("Evgenia");
        player1.installGame(game1);
        player1.play(game1, 1);
        player2.installGame(game2);
        player2.play(game2, 2);

        int expected = 3;
        int actual = store.getSumPlayedTime();

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void playedTimeManyGamesTest() {

        GameStore store = new GameStore();
        Game game1 = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game2 = store.publishGame("Кольца", "Аркады");
        Game game3 = store.publishGame("Утки", "Стратегия");

        Player player = new Player("Andrei");
        player.installGame(game1);
        player.installGame(game2);
        player.installGame(game3);
        player.play(game1, 1);
        player.play(game2, 4);
        player.play(game3, 7);

        int expected = 12;
        int actual = store.getSumPlayedTime();

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void noMostPlayedPlayerTest() {

        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player1 = new Player("Andrei");
        Player player2 = new Player("Evgenia");
        player1.installGame(game);
        player2.installGame(game);

        String expected = null;
        String actual = store.getMostPlayer();

        Assertions.assertEquals(expected, actual);

    }

}
