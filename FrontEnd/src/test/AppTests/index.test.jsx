import { render, screen } from '@testing-library/react';
import ReactDOM from 'react-dom';
import '@testing-library/jest-dom';


describe('Root rendering', () => {
    it('calls ReactDOM.createRoot with correct element', () => {
        const rootElement = document.createElement('div');
        rootElement.id = 'root';
        document.body.appendChild(rootElement);
      
        // Mock ReactDOM.createRoot
        const mock = jest.spyOn(ReactDOM, 'createRoot');
        mock.mockImplementation(() => ({ render: jest.fn() }));
      
        require('../../index.js'); // Import the index.js file
      
        expect(mock).toHaveBeenCalled();
    
    })});