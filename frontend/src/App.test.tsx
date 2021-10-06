import React from 'react';
import { render, screen, fireEvent } from '@testing-library/react';
import App from './App';

//test('renders learn react link', () => {
//  render(<App />);
// const linkElement = screen.getByText(/learn react/i);
//  expect(linkElement).toBeInTheDocument();
//});

const Button = ({ label, onClick }) => {
  return (
    <button
      onClick={() => onClick('1234')}
      testid='my-button'
      aria-label='my-button'
      type='submit'
    >
      {label}
    </button>
  )
}


test('should add button in document', () => {
  let called = false
  const onClick = (test) => {
    called = test
  }

  const { getByLabelText } = render(
    <Button label='MyButton' onClick={onClick} />
  )

  const btnElement = getByLabelText('my-button')
  fireEvent.click(btnElement)

  expect(called).toBe('1234')
  expect(btnElement).toBeInTheDocument()
  expect(btnElement).toHaveTextContent('MyButton')
  expect(btnElement).toHaveAttribute('type', 'submit')
})