export interface ExchangeRate {
    shortName: string;
    name: string;
}

export async function fetchRates(): Promise<ExchangeRate[]> {
    const response = await fetch("/api/");
    const rates = await response.json();
    return rates;
}

export async function fetchRateByShortName(shortName: string): Promise<ExchangeRate | undefined> {
    const response = await fetch("/api/");
    const rates = await response.json();
    return rates.find((rate: ExchangeRate) => rate.shortName === shortName);
} 