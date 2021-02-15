import { useState } from 'react'
import styled from 'styled-components/macro'
import Button from './Button'

export default function AddNewTodo({ onAdd }) {
  const [description, setDescription] = useState('')

  const hasDescription = description.length > 0

  const handleSubmit = (event) => {
    event.preventDefault()
    if (!hasDescription) {
      return
    }
    onAdd(description)
    setDescription('')
  }

  return (
    <Wrapper onSubmit={handleSubmit}>
      <input
        type="text"
        value={description}
        onChange={(event) => setDescription(event.target.value)}
      />
      <Button primary disabled={!hasDescription}>
        Add
      </Button>
    </Wrapper>
  )
}

const Wrapper = styled.form`
  padding: 16px;
  display: grid;
  grid-template-columns: 1fr auto;
  grid-gap: 8px;
`
