import styled from 'styled-components/macro'

export default function AddNewTodo() {
  return (
    <Wrapper>
      <input type="text" /> <button>Add</button>
    </Wrapper>
  )
}

const Wrapper = styled.form`
  padding: 16px;
  display: grid;
  grid-template-columns: 1fr auto;
  grid-gap: 8px;
`
