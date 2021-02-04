import {render} from "@testing-library/react";
import {Route, Router} from "react-router-dom";
import TodoList from "./TodoList";
import React from "react";
import {createMemoryHistory} from "history";

test('test that only todos with the correct status are displayed', () => {

    //GIVEN
    const todos = [
        {id: "1", description: "hallo", status: "OPEN"},
        {id: "2", description: "was geht", status: "IN_PROGRESS"},
        {id: "3", description: "bye", status: "DONE"}
    ];

    const history = createMemoryHistory();
    history.push("/board/open");

    const {queryByText} = render(
        <Router history={history}>
            <Route path="/board/:status">
                <TodoList todos={todos}/>
            </Route>
        </Router>
    );

    //WHEN
    const actualOpen = queryByText(/open/i);
    const actualInProgress = queryByText(/in_progress/i);
    const actualDone = queryByText(/done/i);

    //THEN
    expect(actualOpen).toBeInTheDocument();
    expect(actualInProgress).not.toBeInTheDocument();
    expect(actualDone).not.toBeInTheDocument();
})