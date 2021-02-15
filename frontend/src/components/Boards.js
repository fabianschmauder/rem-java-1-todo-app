import styled from 'styled-components/macro'

export default function Boards() {
  return (
    <Wrapper>
      <section>
        <h2>Todo</h2>
        <ul>
          <li>Item 1</li>
          <li>Item 2</li>
          <li>Item 3</li>
          <li>Item 4</li>
          <li>Item 5</li>
        </ul>
      </section>

      <section>
        <h2>doing</h2>
        <ul>
          <li>Item 1</li>
          <li>Item 2</li>
          <li>Item 3</li>
          <li>Item 4</li>
          <li>Item 5</li>
        </ul>
      </section>

      <section>
        <h2>Done</h2>
        <ul>
          <li>Item 1</li>
          <li>Item 2</li>
          <li>Item 3</li>
          <li>Item 4</li>
          <li>Item 5</li>
        </ul>
      </section>
    </Wrapper>
  )
}

const Wrapper = styled.main`
  overflow-y: scroll;
  padding: 0 16px;
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax(300px, 1fr));
  grid-gap: 20px;
`
