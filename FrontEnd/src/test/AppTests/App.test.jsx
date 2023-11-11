import { render, screen } from '@testing-library/react';
import App from '../../App';

jest.mock("axios", () => ({
  ...jest.requireActual("axios"),
  post: jest.fn(),
}));

test('renders Header component', () => {
  render(<App />);
  const headerElement = screen.getByText(/Cheddit/i)
  expect(headerElement).toBeInTheDocument();
});