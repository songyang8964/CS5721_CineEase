package com.ywxx.cineEase.service.command;

public interface MovieCommand {
    void execute(Long movieId);
    void undo();
}
