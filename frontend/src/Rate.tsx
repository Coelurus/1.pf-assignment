import { useState, useEffect } from 'react'
import { fetchRateByShortName, ExchangeRate } from './exchange-rate-service'
import { useParams } from "react-router-dom";

function Rate() {
    const [loading, setLoading] = useState(true);
    const [rate, setRate] = useState<ExchangeRate>();

    const { rateName } = useParams();

    useEffect(() => {
        const loadRates = async () => {
            setLoading(true);
            setRate(await fetchRateByShortName(rateName!));
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
                        <table>
                            <thead>
                                <tr>
                                    <th>attribute</th>
                                    <th>value</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    Object.entries(rate!).map(([key, value]) => (
                                        <tr key={key}>
                                            <td>{key}</td>
                                            <td>{value}</td>
                                        </tr>
                                    ))
                                }
                            </tbody>
                        </table>
                    )
                }
            </div>
        </>
    )
}

export default Rate