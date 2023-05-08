uniffi::include_scaffolding!("calendar");

pub fn welcome(name: String) -> String {
    format!("Welcome {name}, your calendar is ready")
}
