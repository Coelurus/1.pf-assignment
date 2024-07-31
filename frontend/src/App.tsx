import { useState, useEffect } from 'react'
import { fetchRates, ExchangeRate } from './exchange-rate-service'
import { Link } from "react-router-dom";

import './App.css'

function App() {
  const [loading, setLoading] = useState(true);
  const [rates, setRates] = useState<ExchangeRate[]>([]);

  useEffect(() => {
    const loadRates = async () => {
      setLoading(true);
      setRates(await fetchRates());
      setLoading(false);
    };
    loadRates();
  }, []);

  return (
    <>
      <div>
        {
          loading ? (
            <h3>Still loading...</h3>
          ) : (
            <ol>{
              rates.map((rate: ExchangeRate) => (
                <li key={rate.shortName}>
                  <Link to={`./rates/${rate.shortName}`}>
                    {rate.name} ({rate.shortName})
                  </Link>
                </li>
              ))}
            </ol>
          )}
      </div>
    </>
  )
}

export default App
