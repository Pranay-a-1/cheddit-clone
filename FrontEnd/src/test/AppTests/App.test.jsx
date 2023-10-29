import { render, screen } from '@testing-library/react';
import App from '../../App';

test('renders Header component', () => {
  render(<App />);
  const headerElement = screen.getByText(/Cheddit/i)
  expect(headerElement).toBeInTheDocument();
});