export interface ExchangeRate {
    shortName: string;
    name: string;
}

export async function fetchRates(): Promise<ExchangeRate[]> {
    const response = await fetch("/api/rates");
    const rates = await response.json();
    return rates;
}

export async function fetchRateByShortName(shortName: string): Promise<ExchangeRate | undefined> {
    const response = await fetch(`/api/rates/${shortName}`);
    console.log(response);
    const rate = await response.json();
    console.log(rate);
    return rate;
} 