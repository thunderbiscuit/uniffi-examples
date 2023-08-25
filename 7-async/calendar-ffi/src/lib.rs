use std::time::Duration;
use async_std::future::{timeout, pending};

uniffi::include_scaffolding!("calendar");

#[uniffi::export]
pub async fn say_after(ms: u64, who: String) -> String {
    let never = pending::<()>();
    println!("I'm with {} before the delay!", who);
    timeout(Duration::from_millis(ms), never).await.unwrap_err();
    println!("I'm with {} after the delay!", who);
    format!("Hello, {}!", who)
}
