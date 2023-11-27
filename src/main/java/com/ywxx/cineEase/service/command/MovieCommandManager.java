package com.ywxx.cineEase.service.command;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
@Service
public class MovieCommandManager {
    //responsible for executing commands.
    private List<MovieCommand> commandHistory = new ArrayList<>();

    public void executeCommand(MovieCommand command, Long movieId) {
        command.execute(movieId);
        commandHistory.add(command);
    }
}
