import React, { useState } from 'react';

export default function AddTodo({ onAdd }) {
    const [description, setDescription] = useState('');

    return (
        <form onSubmit={handleSubmit}>
                <input
                    type="text"
                    value={description}
                    onChange={(event) => setDescription(event.target.value)}
                />
            <button type="submit">New Todo</button>
        </form>
    );

    function handleSubmit(event) {
        event.preventDefault();
        onAdd(description);
        setDescription('');
    }
}
