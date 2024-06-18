package com.hugo83.spring02.service;

import java.util.List;

import com.hugo83.spring02.domain.Todo;

public interface TodoService {
    public List<Todo> getTodos() throws Exception;

    public Todo getTodo(int tno) throws Exception;
}
