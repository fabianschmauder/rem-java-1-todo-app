import React from 'react';
import styled from 'styled-components/macro';
import TodoList from './components/TodoList';
import useTodos from './hooks/useTodos';
import useSearch from "./hooks/useSearch";
import {Switch, Route, Redirect} from "react-router-dom";
import Header from "./components/Header";
import Navigation from "./components/Navigation";
import DeleteConfirmation from "./components/DeleteConfirmation";

export default function App() {
    const [todos, create, remove, advance] = useTodos();
    const [search, setSearch, filteredTodos] = useSearch(todos);

    return (
        <Main>
            <Header create={create} search={search} onSearch={setSearch}/>
            <Switch>
                <Route exact path="/">
                    <Redirect to="/board/open"/>
                </Route>
                <Route path="/board/:status">
                    <TodoList todos={filteredTodos} onAdvance={advance} />
                </Route>
                <Route path="/delete/:id">
                    <DeleteConfirmation onDelete={remove} todos={todos}/>
                </Route>
            </Switch>
            <Navigation />
        </Main>
    );
}

const Main = styled.main`
    height: 100vh;
    padding: 0 24px;
    display: grid;
    grid-template-rows: auto 1fr auto;
`;
